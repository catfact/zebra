-- scriptname: dreadmoon
-- v0.0.0 @catfact / @zebra

engine.name = 'DreadMoon'

------------
--- songs
local song = nil

local songs = {
   saints = {
      perform = function()
	 engine.shift_amp(1, 1.0)
	 engine.shift_ratio(1, 2.0)
	 engine.shift_del_time(1, 1.6)	 
	 engine.shift_amp(2, 0.0)
	 engine.shift_ratio(2, 3.0)
	 engine.shift_del_time(2, 1.6)
      end,
   },
   wolf = {
      perform = function()
      end,            
   },
   callout = {
      perform = function()
      end,            
   },
   sixguns = {
      perform = function()
      end,            
   }
}
      
local set_song = function(name)
   song = name
   songs[song].perform()
   redraw()
end

local next_song = function()
   if song == nil then set_song('saints')
   elseif song == 'saints' then set_song('wolf')
   elseif song == 'wolf' then set_song('callout')
   elseif song == 'callout' then set_song('sixguns')
   elseif song == 'sixguns' then set_song('saints')      
   end
end

local prev_song = function()
   if song == nil then set_song('saints')
   elseif song == 'saints' then set_song('sixguns')
   elseif song == 'wolf' then set_song('saints')
   elseif song == 'callout' then set_song('wolf')
   elseif song == 'sixguns' then set_song('callout')      
   end
end

---------------
--- things

local midi_in_device

local function midi_event(data)
   local msg = midi.to_msg(data)
   if msg.type == "note_on" then
      engine.piano_midi_on(msg.note, msg.vel)
   elseif msg.type == "note_off" then
      engine.piano_midi_off(msg.note, msg.vel)
   end
end

function enc(n,z)
end

function key(n,z)
   if z > 0 then
      if n == 2 then
	 prev_song()
      end
      if n == 3 then
	 next_song()
      end
   end
end

function init()
  midi_in_device = midi.connect(1)
  midi_in_device.event = midi_event
  set_song('saints')
end

function redraw()
   screen.clear()
   screen.level(15)
   screen.aa(0)
   screen.font_face(40)
   screen.font_size(12)
   screen.move(20, 20)
   screen.text(song)
   screen.update()
end
