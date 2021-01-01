-- nye 2020 nye 2020

sc = softcut

grid_dirty = true
g = grid.connect()

function sc_init()
  
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
  if voice_state[i].pre > 0 then voice_state[i].pre = 0
  else voice_state[i].pre = 1 end
  sc.pre_level(i, voice_state[i].pre)
  grid_dirty = true
end

function toggle_rec(i)
  if voice_state[i].rec > 0 then voice_state[i].rec = 0
  else voice_state[i].rec = 1 end
  sc.rec_level(i, voice_state[i].rec)
  grid_dirty = true
end

function toggle_play(i)
  if voice_state[i].play > 0 then voice_state[i].play = 0
  else voice_state[i].play = 1 end
  sc.level(i, voice_state[i].play)
  grid_dirty = true
end


function midi_event(data)
  if data[1] == 248 then return end
  --tab.print(data)
  local msg = midi.to_msg(data)
end

function g.key(x, y, z)
  print(""..x.." "..y.." "..z)
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
     -- ??
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

end 

-- 

-- draw ye grid
function grid_redraw()
  for i=1,6 do
    g:led(i, 1, 1)
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