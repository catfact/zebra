-- sins

-- linear plus ji sine instrument

engine.name = 'Zsins'

local nob = dofile(_path.code .. 'zebra/lib/rnob.lua')

local finc = 4
local fincrand = 2

local OscState = {}
OscState.__index = OscState
OscState.new = function()
  local s = {}
  s.f = 220 -- ui linear freq
  s.ri = 1 -- ratio knob index
  s.a = 0 -- linear amp
  s.metaTable = OscState
  return s
end

local UiState = {}
UiState.__index = UiState
UiState.new = function()
  local s = {}
  s.fn = nil -- ui function array
  s.v = 1 -- voice select
  s.metaTable = UiState
  return s
end

local o = OscState.new()
local u = UiState.new()

function init() 
  -- nothing to do
end

-- call assigned sub-handler
function enc(n,z) 
  print("enc",n,z)
  u.uifn.enc[n](z); 
  redraw() 
end
function key(n,z) 
  print("key",n,z)
  u.uifn.key[n](z); 
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
    enc={
      function(z)
        o.f = o.f + finc + math.random(fincrand)
        engine.hz(u.v, o.f * nob[o.ri])
      end,
      function(z)
        o.ri = o.ri + z
        if o.ri < 1 then o.ri = 1
        elseif o.ri > #nob then o.ri = #nob
        end 
        engine.hz(u.v, o.f * nob[o.ri])
      end,
    },
    key={
      --- key 1: toggle amp on/off
      function(z)
        if z > 0 then return end
        if o.a > 0 then o.a = 0
        else o.a = 0.125 end
        engine.amp(u.v, o.a)
      end,
      -- key 2: make amp lower, or maybe higher
      function(z)
        if z > 0 then return end
        if o.a < 0.05 then o.a = 0.25
        else o.a = o.a * 0.75 end
        engine.amp(u.v, o.a)
      end
    },
    draw=function()
      screen.clear()
      screen.move(64,40)
--      screen.level(hold==true and 4 or 15)
      screen.font_face(10)
      screen.font_size(20)
      screen.text_center("ZZIN")
      screen.update()
    end
  }
}

u.fn = uifn.one