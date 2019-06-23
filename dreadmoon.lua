-- scriptname: dreadmoon
-- v0.0.0 @catfact / @zebra

engine.name = 'DreadMoon'

--------------
--- params
cs_CUT1 = controlspec.new(50,5000,'exp',0,800,'hz')
params:add{type="control",id="fc1",controlspec=cs_CUT1,
	   action=function(x) engine.shift_lpf_fc(1, x) end}

cs_CUT1 = controlspec.new(50,5000,'exp',0,800,'hz')
params:add{type="control",id="fc2",controlspec=cs_CUT1,
	   action=function(x) engine.shift_lpf_fc(2, x) end}

cs_GAIN = controlspec.new(0,4,'lin',0,1,'')
params:add{type="control",id="gain",controlspec=cs_GAIN,
	   action=function(x)
	      engine.shift_lpf_gain(1, x)
	      engine.shift_lpf_gain(2, x)
end}


-----------
--- helpers

-- initialize softcut
local softcut_init = function()
   audio.level_cut(1.0)
   audio.level_adc_cut(1)

   for i=1,4 do
      softcut.rec_offset(i, -0.06)
      softcut.level(i, 0.0)
      softcut.rec(i, 1)
      softcut.play(i, 1)
      softcut.loop(i, 1)
      
      softcut.level_input_cut(1, i, 1.0)
      softcut.level_input_cut(2, i, 1.0)
      softcut.pan(i, 0.5)
      
      softcut.filter_dry(1, 1.0)
      softcut.filter_fc(1, 1500)
      softcut.filter_lp(1, 0.0)
      softcut.filter_bp(1, 0.0)
      softcut.filter_rq(1, 20.0)

      softcut.rec_level(i, 1.0)
      softcut.pre_level(i, 0.0)
      
      softcut.loop_start(i, (i+1)*2)
      softcut.loop_end(i, (i+1)*2 + 1)

      softcut.fade_time(1, 0.125)

      softcut.position(i, i+1*2)

      for j=1,4 do
	 softcut.level_cut_cut(i, j, 0)
      end
      softcut.enable(i, 1)
   end
end

-- silence all voices
local softcut_reset = function()
   for i=1,4 do
      softcut.level(i, 0.0)
      for j=1,4 do
	 softcut.level_cut_cut(i, j, 0)
      end
   end
end

------------
--- songs
local song = nil

local songs = {
   saints = {
      perform = function()
	 audio.rev_on()
	 engine.shift_amp(1, 2.0)
	 engine.shift_ratio(1, 2.0)
	 engine.shift_time(1, 1.6)
	 engine.shift_window_size(1, 0.2)
	 engine.shift_time_dispersion(1, 0.1)
	 engine.shift_lpf_fc(1, 8000)
	 engine.shift_amp(2, 0)
	 softcut_reset()
	 audio.level_monitor(0)
      end,
   },
   wolf = {
      perform = function()
	 audio.rev_on()
	 engine.shift_amp(1, 1.0)
	 engine.shift_ratio(1, 0.5)
	 engine.shift_time(1, 0.5)
	 engine.shift_window_size(1, 0.4)
	 engine.shift_time_dispersion(1, 0.2)	 

	 engine.shift_amp(2, 1.0)
	 engine.shift_ratio(2, 2.0)
	 engine.shift_time(1, 0.25)
	 engine.shift_window_size(2, 0.4)
	 engine.shift_time_dispersion(2, 0.2)
	 engine.shift_lpf_fc(2, 2000)
	 engine.shift_hpf_fc(2, 200)
	 softcut_reset()
	 audio.level_monitor(0)
      end,            
   },
   callout = {
      perform = function()
	 audio.rev_off()
	 
	 engine.shift_amp(1, 1.0)
	 engine.shift_time(1, 0.71)	 
	 engine.shift_ratio(1, 1.0)
	 engine.shift_window_size(1, 0.71 * 0.5)
	 engine.shift_time_dispersion(1, 0.71 * 0.25)
	 engine.shift_amp(2, 0.0)
	 
	 softcut_reset()	 
	 softcut.level(1, 1.0)
	 softcut.loop_start(1, 1.0)		    
	 softcut.loop_start(1, 2.42)
	 softcut.position(1, 1.0)
	 audio.level_monitor(0)
      end,            
   },
   other = {
      perform = function()
	 engine.shift_amp(1, 0)
	 engine.shift_amp(2, 0)
	 audio.level_monitor(1)
	 softcut_reset()
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
   elseif song == 'callout' then set_song('other')
   elseif song == 'other' then set_song('saints')      
   end
end

local prev_song = function()
   if song == nil then set_song('saints')
   elseif song == 'saints' then set_song('other')
   elseif song == 'wolf' then set_song('saints')
   elseif song == 'callout' then set_song('wolf')
   elseif song == 'other' then set_song('callout')      
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

function enc(n,delta)
   if n == 1 then
      params:delta("gain", delta)      
   elseif n == 2 then
      params:delta("fc1", delta)
   elseif n == 3 then
      params:delta("fc2", delta)
   end
   redraw()
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
   softcut_init()
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
   screen.move(10, 10)
   screen.text(song)

   screen.level(10)
   screen.font_size(10)
   screen.move(20,30)
   screen.text("f1: ".. params:string("fc1"))
   screen.move(20,40)
   screen.text("f2: ".. params:string("fc2"))
   screen.move(20,50)
   screen.text("g:  ".. params:string("gain"))
   
   screen.update()
end
