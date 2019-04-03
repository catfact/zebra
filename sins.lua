-- sins

-- linear plus ji sine instrument

engine.name = 'Zsins'

nob = dofile(_path.code .. 'zebra/lib/rnob.lua')


local hz_in = -1

local OscState = {}
OscState.__index = OscState
OscState.new = function()
  local s = {}
  s.f = 220   -- ui linear freq
  s.ri = 390  -- fixme: magic! 
  s.a = 0     -- ui linear amp
  s.pan = 0   -- ui pan
  s.metaTable = OscState
  return s
end

local UiState = {}
UiState.__index = UiState
UiState.new = function()
  local s = {}
  s.fn = nil    -- ui function array
  s.v = 1        -- voice select
  s.e1 = 'amp'   -- encoder 1 function
  s.e2 = 'ratio' -- encoder 2 function	
  s.mod = false  -- mod switch flag
  s.setHz = false -- setting-frequency flag
  s.metaTable = UiState
  return s
end

local o = {}
local u = UiState.new()

local numSines = 32

function cleanup()
  -- nothing to do?
end


----------------
--- helper functions

local function update_hz()
  engine.hz(u.v, o[u.v].f * nob[o[u.v].ri][3])
end

local function inc_amp(inc)
  o[u.v].a = o[u.v].a + inc
  if o[u.v].a < 0 then o[u.v].a = 0 end
  if o[u.v].a > 0.5 then o[u.v].a = 0.5 end
  engine.amp(u.v, o[u.v].a)
end

local function inc_ratio(inc) 
  o[u.v].ri = o[u.v].ri + inc
  if o[u.v].ri < 1 then o[u.v].ri = 1
  elseif o[u.v].ri > #nob then o[u.v].ri = #nob
  end 
  update_hz()
end

local function inc_pan(inc)
  o[u.v].pan = o[u.v].pan + inc
  if o[u.v].pan < -1 then o[u.v].pan = -1 end
  if o[u.v].pan > 1 then o[u.v].pan = 1 end      
	engine.pan(u.v, o[u.v].pan)
end

local function inc_voice(inc)
  u.v = u.v + inc
  if u.v < 1 then u.v = 1 end
  if u.v > numSines then u.v = numSines end
end

local function round_hz (hz) 
  return math.floor(hz * 100) * 0.01
end

local function grab_hz()
  print(hz_in)
  if hz_in ~= -1 then
    o[u.v].f = round_hz(hz_in)
    update_hz()
    redraw()
  end
end

---------------------
--- global UI glue

function enc(n,z) 
  if n > 1 then 
    --- call current handler function for keys 2,3
    u.fn.enc[n-1](z)
  else
    --- key 1 selects voice or scrubs hz grab
    if z > 0 then inc_voice(1) else inc_voice(-1) end
    if u.setHz then
      grab_hz()
    end
  end
  redraw()
end

function key(n,z) 
  -- print("key",n,z)
  if n>1 then u.fn.key[n-1](z) 
  else u.mod = z > 0 end
  redraw() 
end

function redraw() u.fn.draw() end


--------------------
--- local UI

local uifn = {
  none = {
    enc={function(z) end, function(z) end},
    key={function(z) end, function(z) end},
    draw=function() end
  },
  one = {
    enc= {
      function(z)
	      if u.e1 == 'freq' then
          o[u.v].f = o[u.v].f + z
          update_hz()
	      else
	        inc_amp(z * 0.01)
	      end
      end,
      function(z)
        if u.e2 == 'ratio' then
          inc_ratio(z)
	      else
	        inc_pan(z * 0.05)
	      end
    end
    }, 
    key={
      --- key 1: select enc1 function
      function(z)
        if u.mod then
          if z > 0 then   -- press
            u.setHz = true
            grab_hz()
          else            -- lift
            u.setHz = false
          end
        else  --- no mod
          print("key 1, no mod: "..z)
  	      if z > 0 then   -- press
  	        u.e1 = 'freq'
  	      else            -- lift
  	        u.e1 = 'amp'
  	      end
  	    end
      end, -- end mod check
      -- key 2: select enc2 function
      function(z)
	      if z > 0 then   -- press
	        u.e2 = 'pan'
	      else            -- lift
	        u.e2 = 'ratio'
	      end
      end
    },
  
    draw=function()
      screen.clear()
      screen.level(15)
      --------------
      -- draw numbers

      screen.aa(0)
      screen.aa(0)
      screen.aa(0)

      screen.font_face(40)
      screen.font_size(12)
      screen.move(1, 8)
      screen.text("A= "..o[u.v].a)
      screen.move(54, 8)
      screen.text("R= "..nob[o[u.v].ri][1].."/"..nob[o[u.v].ri][2])
      screen.move(1, 20)
      screen.text("F= "..o[u.v].f)
      screen.move(54, 20)
      screen.text("P= "..o[u.v].pan)
      
      -----------
      -- draw dots
      local ampStr = ""
      local selStr = ""

      for i=1,numSines do
        if o[i].a > 0.25 then 
          ampStr = ampStr.."#"
        elseif o[i].a > 0 then
          ampStr = ampStr.."|"
        else
          ampStr = ampStr.."."
        end
        if i == u.v then
          selStr = selStr.."^"
        else 
          selStr = selStr.." "
        end
      end 

      -- tiny monospace font
      screen.font_face(25)
      screen.font_size(6)

      screen.move(96, 32)
      screen.text("V= "..u.v)

      screen.move(1, 48)
      screen.text(ampStr)
      screen.move(1, 58)
      screen.text(selStr)
      screen.update()
    end
      
  }
}

function init() 
  u.fn = uifn.one 
  for i=1,numSines do
    o[i] = OscState.new()
  end
  
  local p_pitch = poll.set('pitch_in_l', function(hz) hz_in = hz end)
  p_pitch:start()
end
