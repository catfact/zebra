
	/*
 ___   ___  ___  __            ___ ________  ________  _____ ______
|\  \ |\  \|\  \|\  \         /  /|\   __  \|\   __  \|\   _ \  _   \
\ \  \\_\  \ \  \/  /|_      /  //\ \  \|\ /\ \  \|\  \ \  \\\__\ \  \
 \ \______  \ \   ___  \    /  //  \ \   __  \ \   ____\ \  \\|__| \  \
  \|_____|\  \ \  \\ \  \  /  //    \ \  \|\  \ \  \___|\ \  \    \ \  \
         \ \__\ \__\\ \__\/_ //      \ \_______\ \__\    \ \__\    \ \__\
          \|__|\|__| \|__|__|/        \|_______|\|__|     \|__|     \|__|
                                                                  v141020
"4K/BPM" - 8 channel installation for Sonoretum, Kapelica Gallery, SI
           by Luka Prinčič / Nova deViator <nova@deviator.si>
           released under GNU GPL. feel free to copy, reuse, remix,
           provided that you share under same conditions: GNU GPL.
*/


~syn = {
	// random channel expansion and ramping
	~chanExpan = {
		SinOsc.kr( rrand(0.0001,0.001), 0.25, 0.5, 0.5 )
		*
		LFTri.kr(
			[ // multichannel expansion
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03),
				rrand(0.005,0.03)
			],
		3.99.rand)} ;

	// something that changes the frequency every now and then (0.8 - 1.2)
	~freqVar = {
		LFNoise0.ar(rrand(0.005, 0.03), 0.2, 0.7 + 0.3.rand);
	};

	// bpm master control - oscilating, drifting
	~bpm = LFTri.kr(0.001, 0, 0.2, 0.5 + 0.8.rand);

	z = (
		(
		// kinda bassline
		SinOsc.ar( ((LFSaw.kr(-0.05,1) + 1) * 100 + 40 ),
			LFTri.kr(40,0,1),
			LFSaw.kr(1.5 * ~bpm) )
			* ~chanExpan
			* 0
		)
		+
		( // wierd bleep-bassline
			LFPulse.ar(60 * ~freqVar, 0, 0.5, LFPulse.kr((1/2) * ~bpm, 0.5, 0.03, 0.9))
			* ~chanExpan // random channel expansion
			* 0.5 // volume
		) +
		( // Sine at 0.6666
			SinOsc.ar(265 * ~freqVar, 0, LFPulse.kr((2/3) * ~bpm, 0.5, 0.3) * 0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFPar.ar(420 * ~freqVar, 0, LFPulse.kr((1/2) * ~bpm, 0.5,0.2) * 0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFCub.ar(185 * ~freqVar, 0, LFPulse.kr((1/2) * ~bpm, 0.74,0.2) * 0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume

		) +
		(
			LFCub.ar(1985 * ~freqVar, 0, LFPulse.kr((1/2) * ~bpm, 0.74,0.1) * 0.2)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFCub.ar(9985 * ~freqVar, 0, LFPulse.kr((4/3) * ~bpm, 0.76,0.005)*0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFCub.ar(7985 * ~freqVar, 0, LFPulse.kr((5/3) * ~bpm, 0.24,0.005)*0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			SinOsc.ar(365 * ~freqVar, 0, LFPulse.kr( (4/3) * ~bpm, 0, 0.1)*0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			FreeVerb.ar(LFTri.ar(260 * ~freqVar, 0,
				LFPulse.kr(0.5 * ~bpm,0.25,0.01)*0.3),0.5,0.8,0.1)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			SinOsc.ar(800 * ~freqVar, 0, LFPulse.kr(2 * ~bpm,0,0.1)*0.1)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			SinOsc.ar(5800 * ~freqVar, 0, LFPulse.kr(2 * ~bpm,0,0.01)*0.3)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFCub.ar(820 * ~freqVar, 0, LFPulse.kr( (5/3) * ~bpm, 0, 0.1)*0.1)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			LFPar.ar(7820 * ~freqVar, 0, LFPulse.kr( (5/3) * ~bpm, 0, 0.03)*0.1)
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			WhiteNoise.ar( LFPulse.kr(2 * ~bpm,0.5,0.001,1) )/2
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			WhiteNoise.ar( LFPulse.kr(1 * ~bpm,0.5,0.001,1) )/2
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			WhiteNoise.ar( LFPulse.kr( (5/3) * ~bpm,0.5,0.001,1) )/4
			* ~chanExpan // random channel expansion
			* 1 // volume
		) +
		(
			WhiteNoise.ar( LFPulse.kr( (4/3) * ~bpm,0.5,0.001,1) )/4
			* ~chanExpan // random channel expansion
			* 1 // volume
		)
	);

	~out = CombC.ar(
		DelayN.ar(
			DelayN.ar(z,
				0.5, [0.47, 0.75, 0.51, 0.42, 0.65, 0.67, 0.56, 0.3], 1, z),
			0.5, 0.5, 1, z),
		0.1, LFNoise0.kr(0.5 * ~bpm, 0.05, 0.001).abs, 2, z);

	~out = ~out + (z * SinOsc.kr(0.001, 0, 0.33, 0.66));
	~out = Limiter.ar((~out),0.9, 0.1);
	~out = FreeVerb.ar(~out, 0.2 * ~freqVar, 1, 0.1);


}.play;

~cleanup = { ~syn.free; }
/*
~cleanup.value
*/
