Engine_Zsins : CroneEngine {
	var <pianovoice;
	
	*new { arg context, doneCallback;
		^super.new(context, doneCallback);
	}
	
	alloc {

		// somewhat piano like thing - noise exciter, comb resonator
		SynthDef.new(\comb_piano, {
			arg out=0, amp=0.125, hz=220,
			noise_hz = 4000, noise_attack=0.002, noise_decay=0.06,
			tune_up = 1.0005, tune_down = 0.9996, string_decay=6.0,
			lpf_ratio=2.0, lpf_rq = 4.0, hpf_hz = 40;

			var noise, string, delaytime, lpf, noise_env, snd;

			noise_env = Decay2.ar(Impulse.ar(0));
			noise = LFNoise2.ar(noise_hz) * noise_env;

			delaytime = 1.0 / (hz * [tune_up, tune_down]);
			string = Mix.new(CombL.ar(noise, delaytime, delaytime, string_decay));

			snd = RLPF.ar(string, lpf_ratio * hz, lpf_rq) * amp;
			snd = HPF.ar(snd, hpf_hz);

			Out.ar(out, snd.dup);
			DetectSilence.ar(snd, doneAction:2);
		}).send(s);


		// convenience: play a piano note (num, vel)
		this.addCommand(\piano_midi_on, "ii", {
			pianovoice[i] = Synth.new(\comb_piano, [
				\hz, note.midicps,
				\amp, vel.linlin(20, 120, -20.dbamp, -18.dbamp),
				\lpf_ratio, vel.linlin(50, 120, 1.0, 3.0),
				\lpf_rq, vel.linlin(50, 120, 4.0, 8.0),
				\string_decay, vel.linlin(50, 120, 4.0, 8.0),
				\noise_hz, vel.linlin(50, 120, 2000, 4000)
			]);<
		});

		// convenience, stop a piano note (num, vel)
		this.addCommand(\piano_midi_off, "ii", {
			// FIXME: does nothing!
			// gotta implement some kind of damping...??
		});

	}

	free {
		pianovoice.do({ |v| if (v.notNil, { ev.free; }); });
	}
	
}