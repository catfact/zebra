-- sins

-- linear plus ji sine instrument

engine = 'Sines'

local finc = 4
local fincrand = 2

local State = {}
State.__index = State
State.new = function()
  local s = {}
  s.f = 220 -- ui linear freq
  s.ri = 1 -- ratio knob index
  s.v = 1 -- ui voice select
  s.a = 0 -- ui linear amp
  s.metaTable = State
  return s
end

local state = State.new()
local state2 = State.new() --- "its extra"

init = function() end

enc = function(n,z) state.uifn.enc[n](z) end
key = function(n,z) state.uifn.key[n](z) end

local uifn = {

  none = {
    enc={function(z) end, function(z) end},
    key={function(z) end, function(z) end}
  },

  one = {
    enc={
      function(z)
        state.f = state.f + finc + math.random(fincrand)
        engine.hz(1, state.v, state.f * state.r)
      end,
      function(z)
        state.ri = 
        engine.hz(1, state.v, state.f * nob[state.ri])
      end,

    key={
      function(z)      
        engine.hz(1, state.v, state.f * state.r)
      end,
    }
  }

state.uifn = uifn.one