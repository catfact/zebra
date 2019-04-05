-- cross
-- @zebra

-- softcut cross-patch test / demo

engine.name = 'Zsins'

local sc = require 'softcut'

local nob = dofile(_path.code..'zebra/lib/rnob.lua')

local state = {
  freeze = { false, false },
  ri = { 390, 390 } --- FIXME: magic
}
-------
--- local functions

local toggle_freeze = function(i, bool)
  if state.freeze[i] then
    state.freeze[i] = false
    sc.pre_level(i, 0)
    sc.rec_level(i, 1)
  else
    state.freeze[i] = true
    sc.pre_level(i, 1)
    sc.rec_level(i, 0.0)
  end  
end

local inc_nob = function(i, z)
    state.ri[i] = state.ri[i] + z
    if state.ri[i] < 0 then  state.ri[i] = 0 end
    if state.ri[i] > #nob then  state.ri[i] = #nob end
    return nob[state.ri[i]]
end

----
-- UI handlers

function enc(n,z)
  if n == 2 then
    sc.rate(1, inc_nob(1, z)[3])
    redraw()
  elseif n == 3 then
    sc.rate(2, inc_nob(2, z)[3])
    redraw()
  end
end

function key(n,z)
  if n == 2 and z > 0 then
    toggle_freeze(1)
    redraw()
  elseif n == 3 and z > 0 then
    toggle_freeze(2)
    redraw()
  end
end


function redraw()
  screen.clear()
  screen.move(10, 10)
  screen.text("r1: "..nob[state.ri[1]][1].."/"..nob[state.ri[1]][2])
  screen.move(10, 20)
  screen.text("r2: "..nob[state.ri[2]][1].."/"..nob[state.ri[2]][2])
  screen.move(10, 30)
  if state.freeze[1] then screen.text("freeze 1") 
    else screen.text("run 1") end
  screen.move(10, 40)
  if state.freeze[2] then screen.text("freeze 2") 
    else screen.text("run 2") end
  screen.update()
end

function init()
  
-- cut global
audio.level_cut(1.0)
audio.level_adc_cut(1)
audio.level_ext_cut(1)

-- cut voice 1
sc.level(1, 1.0)
sc.play(1, 1.0)
sc.rec(1, 1.0)
sc.level_input_cut(1, 1, 1.0)
sc.level_input_cut(2, 1, 1.0)
sc.pan(1, 0.5)

sc.loop_start(1, 1)
sc.loop_end(1, 3.0)
sc.loop(1, 1)

sc.loop_start(1, 1)
sc.loop_end(1, 3.0)
sc.loop(1, 1)
sc.position(1, 1)
sc.enable(1, 1)

sc.fade_time(1, 0.1)

sc.filter_dry(1, 1.0);
sc.filter_fc(1, 1200);
sc.filter_lp(1, 0);
sc.filter_bp(1, 0.0);
sc.filter_rq(1, 20.0);

-- cut voice 2
sc.level(2,1.0)
sc.play(2, 1.0)
sc.rec(2, 1.0)
sc.level_input_cut(1, 2, 1.0)
sc.level_input_cut(2, 2, 1.0)

sc.pan(2, -0.5)

sc.buffer (2, 2)

sc.loop_start(2, 1)
sc.loop_end(2, 3.0)
sc.loop(2, 1)

sc.position(2, 1)
sc.enable(2, 1)

sc.filter_dry(2, 1.0);
sc.filter_fc(2, 1200);
sc.filter_lp(2, 0);
sc.filter_bp(2, 0.0);
sc.filter_rq(2, 20.0);

    sc.rec_level(1, 0.25)
    sc.rec_level(2, 0.25)

------
-- cross
sc.level_cut_cut(1, 2, 0.25)
sc.level_cut_cut(2, 1, 0.25)
sc.buffer_clear()

end