-- nye 2020 nye 2020

sc = softcut
ji = require 'intonation'
grid_dirty = true
g = grid.connect()



function sc_init()
  
    local cut_pans = { -0.5, -0.25, 0.25, 0.5, -0.25, 0.25 }
    local loop_start = {0, 40, 80, 120, 0, 150}
    local loop_end = {30, 40 + 28, 80 + 27, 120 + 26, 140, 300}
    local buffer = {1, 1, 1, 1, 2, 2}
    local loop = { 1, 1, 1, 1, 0, 0}
    
    --- cut voices
    for i=1,6 do
      sc.rec_offset(i, -0.06)
      sc.level(i, 0.0)
      sc.rec(i, 1)
      sc.play(i, 1)

      sc.level_input_cut(1, i, 1.0)
      sc.level_input_cut(2, i, 1.0)
      sc.pan(i, cut_pans[i])
      sc.filter_dry(1, 1.0);
      sc.filter_fc(1, 900 + (300 * i));
      sc.filter_lp(1, 0.5);
      sc.filter_bp(1, 0.25);
      sc.filter_rq(1, 20.0);

      sc.rec_level(i, 1.0)
      sc.pre_level(i, 0.5)
      
      sc.loop_start(i, loop_start[i])
      sc.loop_end(i, loop_end[i])
      sc.buffer(i, buffer[i])

      sc.fade_time(1, i + 2)
      sc.loop(i, loop[i])
      sc.rate_slew_time(i, 0.4) 
      sc.position(i, loop_start[i])

      for j=1,4 do
          sc.level_cut_cut(i, j, 0)
      end
      sc.enable(i, 1)
  end  
  sc.buffer_clear()
end

voice_state = {}
for i=1,6 do
  voice_state[i] = {
    pos = 1 + (i-1) * (sc.BUFFER_SIZE - 1) / 7 ,
    play = 0,
    rec = 0,
    pre = 0,
  }
end

function toggle_pre(i)
  print("toggle pre "..i)
  if voice_state[i].pre > 0 then voice_state[i].pre = 0
  else voice_state[i].pre = 1 end 
  sc.pre_level(i, voice_state[i].pre)
  grid_dirty = true
end

function toggle_rec(i)
  print("toggle rec "..i)
  if voice_state[i].rec > 0 then voice_state[i].rec = 0
  else voice_state[i].rec = 1 end
  sc.rec_level(i, voice_state[i].rec)
  grid_dirty = true
end

function toggle_play(i)
  print("toggle play "..i)
  if voice_state[i].play > 0 then voice_state[i].play = 0
  else voice_state[i].play = 1 end
  sc.level(i, voice_state[i].play)
  grid_dirty = true
end


function midi_event(data)
  if data[1] == 248 then return end
  --tab.print(data)
  local msg = midi.to_msg(data)
  -- tab.print(msg)
  if msg.type == "note_on" then note_on(msg.note) end
  if msg.type == "note_off" then note_off(msg.note) end
end

midi_note_count = 0
scale = ji.normal()

function note_on(num)
  midi_note_count = midi_note_count + 1
  if midi_note_count > 4 then return end
  local d = num - 62
  local oct = math.pow(2, math.floor(d / 12))
  deg = (d % 12) + 1
  print("degree: " .. deg)
  local ratio = scale[deg]
  --local rate = ratio[1] / ratio[2] * oct
  ratio = ratio * oct
  print("setting ratio " .. midi_note_count .. " = " .. ratio)
  sc.rate(midi_note_count, ratio)
end

function note_off(num)
  midi_note_count = midi_note_count - 1
end


base_rates ={0.25, 0.5, 1, 1, 1, 1}
function g.key(x, y, z)
  --print(""..x.." "..y.." "..z)
  if z == 0 then return end
  if x > 6 then return end
  
  if y == 1 then
    sc.position(x, voice_state[x].pos)
  elseif y == 2 then
    toggle_play(x)
  elseif y == 3 then
    toggle_rec(x)
  elseif y == 4 then
    toggle_pre(x)
  elseif y == 5 then
    sc.rate(x, base_rates[x])
  elseif y == 6 then
    -- ??
  end
end

init = function()
  m = midi.connect(3)
  m.event = midi_event
  
  redraw_metro = metro.init()
  redraw_metro.event = function()
    if grid_dirty then
      grid_redraw()
      grid_dirty = false
    end
  end
  redraw_metro.time = 0.05
  redraw_metro:start()
  
  redraw()
  grid_redraw()
  
  sc_init()
end 

-- 

-- draw ye grid
function grid_redraw()
  for i=1,6 do
    g:led(i, 1, 1)
    g:led(i, 5, 1)
    if voice_state[i].play > 0 then 
      g:led(i, 2, 15)
    else 
      g:led(i, 2, 0)
    end
    if voice_state[i].rec > 0 then 
      g:led(i, 3, 15)
    else 
      g:led(i, 3, 0)
    end
    if voice_state[i].pre > 0 then 
      g:led(i, 4, 15)
    else 
      g:led(i, 4, 0)
    end
  end
  g:refresh()
end

function redraw()
  screen.clear()
  screen.line_width(1)
  screen.aa(0)
  screen.move(10, 20)
  screen.text("NYE2020")
  screen.update()
end