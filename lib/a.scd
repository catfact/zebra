
~pitches = Array.fill(64, {|i|
	110 * ((i%7).wrap(1, 4)) / ((i% 8).wrap(1, 6)) + (i % 6) + (i/4096.0);
});

Routine {

	SynthDef.new(\vosc, {
		arg out=0, hz=110, level=1.0,
		buf=0, numbufs=4, 
		index=0.0, amplag=0.05, hzlag = 10.0,
		gate=1, attack=0.1, release=60.0,
		pan=0;
		var osc, ampenv, amp;
		hz = Lag.kr(hz, hzlag);
		ampenv = Env.asr(attack, 1.0, release);
		amp = EnvGen.ar(ampenv, gate:gate, doneAction:2);
		index = Lag.kr(index, amplag);
		osc = VOsc.ar(buf + (index * numbufs), hz);
		Out.ar(out, Pan2.ar(osc*amp*level, pan));
	}).send(s);

	
	~vosc_bufs = Buffer.allocConsecutive
	(	4, s, 1024, 1,
		{	arg buf, i;
			var sa;
			sa = Array.fill
			(	i+1,
				{	arg j;
					var val;
					if (j<i, {val=0}, {val=1});
					val.postln
				}
			);
			buf.sine1Msg(sa);
		}
	);

	s.sync;

	~vg = Group.tail(s);

	~voscs = Array.fill(64, {|i|
		Synth.new(\vosc, [\level, 0.01, \hz, ~pitches[i], \attack, 30.0], ~vg); 
	});


	~vg.set(\lag, 10.0);
	~vg.set(\lag, 0.1);
	~vg.set(\index, 0.0);
	~vg.set(\level, 0.011);

	~voscs.do({|syn, i| syn.set(\pan, i / 128 - 0.25)});

}.play;

~cleanup = {
	Routine { 
		~vg.set(\gate, 0);
		10.wait;
		~vosc_bufs.do({ arg buf; buf.free; });
	}.play;
}