// Zsins
// a lot of sines
// with amplitude modulation

Engine_Zsins : CroneEngine {
	classvar num;
	var <synth;

	*initClass {  num = 32; }

	*new { arg context, doneCallback;
		^super.new(context, doneCallback);
	}

	alloc {
		var server = Crone.server;
		var def = SynthDef.new(\zsin, {
			arg out, hz=220, hz_lag=0.005, 
				amp=0.0, amp_atk=0.001, amp_rel=0.05,
				pan=0, pan_lag=0.005, 
				am_in=0, am_mul=0, am_add=1.0;
			var amp_mod, amp_, hz_, pan_;
			amp_ = LagUD.ar(K2A.ar(amp), amp_atk, amp_rel);
			amp_mod = SoundIn.ar(am_in) * LagUD.ar(K2A.ar(am_mul), amp_atk, amp_rel) + LagUD.ar(K2A.ar(am_add), amp_atk, amp_rel);
			hz_ = Lag.ar(K2A.ar(hz), hz_lag);
			pan_ = Lag.ar(K2A.ar(pan), pan_lag);
			Out.ar(out, Pan2.ar(SinOsc.ar(hz_) * amp_ * amp_mod, pan));
		});
		def.send(server); 
		server.sync;
		
		synth = Array.fill(num, { Synth.new(\zsin, [\out, context.out_b], target: context.xg) });

		#[\hz, \amp, \pan, \amp_atk, \amp_rel, \hz_lag, \pan_lag, \am_mul, \am_add].do({
			arg name;
			this.addCommand(name, "if", {
				arg msg;
				var i = msg[1] -1;
				if(i<num && i >= 0, { 
					synth[i].set(name, msg[2]);
				});
			});
		});
		
		this.addCommand(\am_in, "ii", { 
		  arg msg;
		  var i, j;
		  i = msg[1] - 1;
		  j = msg[2] - 1;
		  if (i<num && i>=0 && j<2 && j >= 0, {
		    synth[i].set(\am_in, j);
		  });
		});

	}

	free {
		synth.do({ |syn| syn.free; });
	}
}
