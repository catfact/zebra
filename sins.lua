-- sins

-- linear plus ji sine instrument

engine.name = 'Zsins'

nob = dofile(_path.code .. 'zebra/lib/rnob.lua')

local OscState = {}
OscState.__index = OscState
OscState.new = function()
  local s = {}
  s.f = 220 -- ui linear freq
  s.ri = 390 -- magic! 
  s.a = 0 -- linear amp
  s.pan = 0
  s.metaTable = OscState
  return s
end

local UiState = {}
UiState.__index = UiState
UiState.new = function()
  local s = {}
  s.fn = nil -- ui function array
  s.v = 1 -- voice select
  s.e1 = 'amp' -- encoder 1 function
  s.e2 = 'ratio' -- encoder 2 function	
  s.metaTable = UiState
  return s
end

local o = {}
local u = UiState.new()

local numSines = 32

function cleanup()
  -- nothing to do?
end

-- call assigned sub-handler
function enc(n,z) 
  -- print("enc",n,z)
  if n>1 then 
    u.fn.enc[n-1](z)
  else
    if z > 0 then u.v = u.v + 1
    else u.v = u.v - 1 end
    if u.v < 1 then u.v = 1 end
    if u.v > numSines then u.v = numSines end
  end
  redraw()
end
function key(n,z) 
  print("key",n,z)
  if n>1 then u.fn.key[n-1](z) end
  redraw() 
end

function redraw() u.fn.draw() end

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
          engine.hz(u.v, o[u.v].f * nob[o[u.v].ri][3])
	      else
	        o[u.v].a = o[u.v].a + z * 0.02
	        if o[u.v].a < 0 then o[u.v].a = 0 end
	        if o[u.v].a > 0.5 then o[u.v].a = 0.5 end
	        engine.amp(u.v, o[u.v].a)
	      end
      end,
      function(z)
        if u.e2 == 'ratio' then
          o[u.v].ri = o[u.v].ri + z
          if o[u.v].ri < 1 then o[u.v].ri = 1
          elseif o[u.v].ri > #nob then o[u.v].ri = #nob
          end 
          engine.hz(u.v, o[u.v].f * nob[o[u.v].ri][3])
	      else
	        o[u.v].pan = o[u.v].pan + z*0.1
          if o[u.v].pan < -1 then o[u.v].pan = -1 end
          if o[u.v].pan > 1 then o[u.v].pan = 1 end      
	        engine.pan(u.v, o[u.v].pan)
	      end
    end
    }, 
    key={
      --- key 1: select enc1 function
      function(z)
	      if z > 0 then u.e1 = 'freq'
	      else u.e1 = 'amp' end
      end,
      -- key 2: select enc2 function
      function(z)
	      if z > 0 then u.e2 = 'pan'
	      else u.e2 = 'ratio' end
      end
    },
    draw=function()
      screen.clear()
      screen.font_face(1)
      screen.font_size(8)
      screen.move(10, 20)
      screen.text("A = "..o[u.v].a)
      screen.move(60, 20)
      screen.text("R = "..nob[o[u.v].ri][1])
      screen.move(100, 20)
      screen.text("/ "..nob[o[u.v].ri][2])
      screen.move(20, 60)
      screen.text("V = "..u.v)
      screen.move(20, 40)
      screen.text("F = "..o[u.v].f)
      screen.move(60, 40)
      screen.text("P = "..o[u.v].pan)
      screen.update()
    end
  }
}

function init() 
  u.fn = uifn.one 
  for i=1,numSines do
    o[i] = OscState.new()
  end
end
