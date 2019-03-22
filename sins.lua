-- sins

-- linear plus ji sine instrument

engine = 'zsins'

local nob = dofile(script_dir..'zebra/lib/rnob.lua')

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

init = function() 
  u.v = 1
end

enc = function(n,z) u.uifn.enc[n](z) end
key = function(n,z) u.uifn.key[n](z) end

local keyfn = {
  
}

local uifn = {
  none = {
    enc={function(z) end, function(z) end},
    key={function(z) end, function(z) end}
  },

  one = {
    enc={
      function(z)
        o.f = o.f + finc + math.random(fincrand)
        engine.hz(1, u.v, o.f * nob[o.ri])
      end,
      function(z)
        o.ri = o.ri + z
        if o.ri < 1 then o.ri = 1
        elseif o.ri > #nob then o.ri = #nob
        end 
        engine.hz(1, u.v, o.f * nob[o.ri])
      end,
    },
    key={
      function(z)      
        engine.hz(1, state.v, state.f * state.r)
      end,
    }
  }
}

ustate.fn = uifn.one