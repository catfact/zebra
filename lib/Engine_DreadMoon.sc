Engine_DreadMoon : CroneEngine {
	// array of piano voice synths (self-freeing)
	var piano_voice;
	// array of FM "organ" voices
	var organ_voice;
	// granular pitch-shift voices
	var shift_del_voice;
	var shift_del_buf;
	
	var num_shift = 2;
	var shift_del_maxtime = 8.0;

	
	*new { arg context, doneCallback;
		^super.new(context, doneCallback);
	}
	
	alloc {
		
		// somewhat piano like thing - noise exciter, comb resonator
		SynthDef.new(\comb_piano, {
			arg out=0, amp=0.125, hz=220,
			noise_hz = 4000, noise_attack=0.002, noise_decay=0.06,
			tune_up = 1.0005, tune_down = 0.9996, string_decay=6.0,
			lpf_ratio=2.0, lpf_rq = 4.0, hpf_hz = 40, damp=0, damp_time=0.1;

			var noise, string, delaytime, lpf, noise_env, snd, damp_mul;

			damp_mul = LagUD.ar(K2A.ar(1.0 - damp), 0, damp_time);

			noise_env = Decay2.ar(Impulse.ar(0));
			noise = LFNoise2.ar(noise_hz) * noise_env;

			delaytime = 1.0 / (hz * [tune_up, tune_down]);
			string = Mix.new(CombL.ar(noise, delaytime, delaytime, string_decay * damp_mul));

			snd = RLPF.ar(string, lpf_ratio * hz, lpf_rq) * amp;
			snd = HPF.ar(snd, hpf_hz);

			Out.ar(out, snd.dup);
			DetectSilence.ar(snd, doneAction:2);
		}).send(Crone.server);


		// simple, moogish monosynth voice
		SynthDef.new(\fm_organ, {			
			arg out=0, amp=1.0,
			hz1, hz2, shape1=0, shape2=0,
			fm_idx = 0,
			fc=1200, gain=0.1,
			amp_atk=0.01, amp_rel=0.2,
			osc1_amp=0.5, osc2_amp=0.5;

			var hz1mod, osc1, osc2, snd;

			osc2 = SelectX.ar(shape2, [SinOsc.ar(hz2), DPW3Tri(hz2), Saw.ar(hz2), Pulse.ar(hz2)]);
			hz1mod = (osc2 * fm_idx + 1.0) * hz1;
			osc1 = SelectX.ar(shape1, [SinOsc.ar(hz1mod), DPW3Tri(hz1mod), Saw.ar(hz1mod), Pulse.ar(hz1mod)]);
			fc = Lag.kr(fc, 0.1);
			gain = Lag.kr(gain, 0.1);
			snd = MoogFF.ar(osc1*osc1_amp + osc2*osc2_amp, fc, gain);
			Out.ar(out, (snd * LagUD.ar(K2A.ar(amp, amp_atk, amp_rel))).dup);
		}).send(Crone.server);

		// granular pitch-shift, with delay
		SynthDef.new (\shift_del, {
			arg buf, out=0, amp=1.0, time=0.6, ratio=2.0,
			windowSize = 0.2, pitchDispersion = 0.0, timeDispersion = 0.1;
			var snd = PitchShift.ar(BufDelayL.ar(buf, SoundIn.ar([0,1]), time),
				windowSize:windowSize, pitchDispersion:pitchDispersion, timeDispersion:timeDispersion,
				pitchRatio:ratio);
			Out.ar(out, Mix.new(snd)*amp);
		}).send(Crone.server);


		// convenience: play a piano note (num, vel)
		this.addCommand(\piano_midi_on, "ii", {
			arg msg;
			var note, vel;
			note = msg[1];
			vel = msg[2];
			//[note, vel].postln;
			piano_voice[note] = Synth.new(\comb_piano, [
				\hz, note.midicps,
				\amp, vel.linlin(20, 120, -20.dbamp, -18.dbamp),
				\lpf_ratio, vel.linlin(50, 120, 1.0, 3.0),
				\lpf_rq, vel.linlin(50, 120, 4.0, 8.0),
				\string_decay, vel.linlin(50, 120, 4.0, 8.0),
				\noise_hz, vel.linlin(50, 120, 2000, 4000)
			], context.xg);
		});

		// convenience, stop a piano note (num, vel)
		this.addCommand(\piano_midi_off, "ii", {
			arg msg;
			var note, vel;
			note = msg[1];
			vel = msg[2];
			//[note, vel].postln;
			if(piano_voice[note].notNil, { 
				piano_voice[note].set(\damp_time, vel.linlin(0, 127, 1.0, 0.05));
				piano_voice[note].set(\damp, 1);
			});
		});

		
		this.addCommand(\shift_amp, "if", {
			arg msg;
			shift_del_voice[msg[1]-1].set(\amp, msg[2]);
		});

		
		this.addCommand(\shift_del_time, "if", {
			arg msg;
			shift_del_voice[msg[1]-1].set(\time, msg[2]);
		});

		this.addCommand(\shift_ratio, "if", {
			arg msg;
			msg.postln;
			shift_del_voice[msg[1]-1].set(\ratio, msg[2]);
		});
	
		piano_voice = Array.newClear(128);
		organ_voice = Array.newClear(128);

		shift_del_buf = Array.fill(num_shift, {
			Buffer.alloc(Crone.server, shift_del_maxtime * Crone.server.sampleRate, 1);
		});
		
		shift_del_voice = Array.fill(num_shift, { |i|
			Synth.new(\shift_del, [\amp, 0, \buf, shift_del_buf[i].bufnum], context.xg)
		});
		
	}

	free {
		piano_voice.do({ |v| if (v.notNil, { v.free; }); });
		organ_voice.do({ |v| if (v.notNil, { v.free; }); });
		shift_del_voice.do({ |v| if (v.notNil, { v.free; }); });
	}
}
