Engine_RedFrikTweets : CroneEngine {

	classvar <numTweets;
	classvar <numGroups;
	var tweet_g;

	*initClass {
		numGroups = 2;
		numTweets = RedFrikTweets.tweets.size;
		numTweets.postln;
	}

	*new { arg context, doneCallback;
		^super.new(context, doneCallback);
	}

	alloc {
		tweet_g = Array.newClear(2);
		this.addCommand(\tweet, "i", { arg msg;
			var gidx, tidx;
			msg.postln;
			gidx = msg[1]-1;
			tidx = msg[2]-1;
			if(tweet_g[gidx].notNil, { tweet_g[gidx].free; });
			tweet_g[gidx] = Group.new(context.xg);x
			if(tidx >= numTweets, { tidx = numTweets - 1; });
			if(tidx < 0, { tidx = 0; });
			RedFrikTweets.tweets[tidx].value(tweet_g[gidx]);
		});
	}


}

RedFrikTweets {

	*tweets {
^[
		//--tweet0000
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{GlitchRHPF.ar(GbmanN.ar([2300,1150]),LFSaw.ar(Pulse.ar(4,[1,2]/8,1,LFPulse.ar(1/8)/5+1))+2)}.play(target:target)//#SuperCollider
		},

		//--tweet0008
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({x=LFNoise1.ar(0.5!2);Formlet.ar(Crackle.ar(x.range(1.8,1.98)),TExpRand.ar(200,2e3,x).lag(2),x.range(5e-4,1e-3),0.0012)}, target:target)//#SuperCollider
		},

		//--tweet0010
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;LeakDC.ar(a.ar(a.ar(0.31),a.ar(a.ar(0.21),a.ar(a.ar(0.11,a.ar(0.01)),0,a.ar([2,3],0,400))),a.ar([0.3,0.21])))}, target:target)//#SuperCollider
		},

		//--tweet0011
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({f={|o,i|if(i>0,{SinOsc.ar([i,i+1e-4]**2*f.(o,i-1),f.(o,i-1)*1e-4,f.(o,i-1))},o)};f.(60,6)/60}, target:target)//#SuperCollider
		},

		//--tweet0014
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOscFB;sum({|i|a.ar(a.ar(a.ar(a.ar(i+1,1/9,999),1/9,a.ar(1/9,1,1/9)),a.ar(0.1,3),i+2*999),a.ar(1/9,1/9),1/9)}!9)!2}, target:target)//#SuperCollider
		},

		//--tweet0016
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({b=LocalBuf(9e4,2).clear;i=Sweep.ar(BufRd.ar(2,b,Saw.ar(12,3e4,4e4)),9e4);BufWr.ar(Saw.ar([8,9]),b,i);BufRd.ar(2,b,i)/2}, target:target)//#SuperCollider
		},

		//--tweet0017
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({b=LocalBuf(8e4,2).clear;i=Sweep.ar(BufRd.ar(2,b,Saw.ar(3.1,4e4,4e4)),8e4);BufWr.ar(Blip.ar([2,3]),b,i);BufRd.ar(2,b,i)}, target:target)//#SuperCollider
		},

		//--tweet0018
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({b=LocalBuf(5e3,2).clear;i=Sweep.ar(BufRd.ar(2,b,Saw.ar(50,2e3,5e3)),6e4);BufWr.ar(Saw.ar([4,3]),b,i);BufRd.ar(2,b,i)/6}, target:target)//#SuperCollider
		},

		//--tweet0019
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({b=LocalBuf(1e4,2).clear;i=Sweep.ar(BufRd.ar(2,b,Saw.ar(1,2e3,5e3)),5e5);BufWr.ar(Saw.ar([8,50]),b,i);BufRd.ar(2,b,i)/3}, target:target)//#SuperCollider
		},

		//--tweet0020
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFPulse;b=(1..4);Mix(a.ar(a.ar(a.ar(a.ar(b/32)+1/8)+1*b)+(Mix(a.ar(b/64))+a.ar(4/b)*(a.ar(a.ar(b/8))*2+b))*100))/8!2}, target:target)//#SuperCollider
		},

		//--tweet0022
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=1/(2..5);GVerb.ar(Splay.ar(Ball.ar(LPF.ar(Impulse.ar(a),500),7-(1/a),1e-5,LFNoise2.kr(a/5,2e-4,12e-4))/2),5,0.5,0.9)}, target:target)//#SuperCollider
		},

		//--tweet0023
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({Splay.ar({|i|f=i+5*99;RHPF.ar(Ringz.ar(Ball.ar(Saw.ar(i+1)>0,SinOsc.kr(0.1,0,1/5,0.3),0.05,0.02)/99,f,0.05),f,0.1)}!5)}, target:target)//#SuperCollider
		},

		//--tweet0024
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{|j|r{{|i|x=sin(i/5+(j*5));Ndef(i%5+(j*5),{Pan2.ar(LFCub.ar(j*2+x*40+400+i)/15,i%5/2-1)}).play;wait(x.abs+0.5)}!500}.play(target:target)}!5//#SuperCollider
		},

		//--tweet0028
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({MoogFF.ar(LFTri.ar(CombN.ar(Duty.ar(1/8,0,Dseq(Dshuf(List.fib(16)%8*99,8),inf)),4,4,16))/4,LFTri.kr(1/16,0,2e3,3e3))!2}, target:target)//#SuperCollider
		},

		//--tweet0030
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFPar;GVerb.ar(VarSaw.ar(a.ar(1,0,5,a.ar([0.05,0.04],0,50,160).round(50)),0,a.ar(0.2,0,0.5,a.ar(3,0,0.2,0.5)))/8,80)}, target:target)//#SuperCollider
		},

		//--tweet0032
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{Splay.ar({|i|l=LFTri.ar(1/6,i/1.5,2.5,3.5).round;SinOsc.ar(142.857*l,lag(l,i-3/6),1-poll(0.142857*l,10/6,"\t\t"))}!6)}.play(target:target)//#SuperCollider
		},

		//--tweet0033
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({f=LFPar.ar(1/14).round*20+80;Splay.ar(LFPar.ar({|i|[i+1*f,i*f+(i+1/3)]}!4)>BrownNoise.ar(Pulse.ar({|i|i+1}!4,0.35))/3)}, target:target)//#SuperCollider
		},

		//--tweet0034
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({x=CombN.ar(Phasor.ar(0,{|i|i+1/20}!22),0.042,0.042);y=Phasor.ar(LPF.ar(x,LFPar.ar(1/99,0,400,500)),x);Splay.ar(y)*0.25}, target:target)//#SuperCollider
		},

		//--tweet0035
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({x=CombC.ar(Phasor.ar(0,{|i|i+1/4}!5),0.2,LFPar.ar(0.09,0,0.05,0.1).round(0.022));Splay.ar(Phasor.ar(BPF.ar(x,50),x)/4)}, target:target)//#SuperCollider
		},

		//--tweet0036
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({Splay.ar({|i|SinOsc.ar(i+SinOsc.ar(0.01,a=pi/[2,4,8]@@i,0.1,1)*80+SinOsc.ar(i+1*1e-4+i),a,SinOsc.ar(i+1*1e-3,a)/4)}!9)}, target:target)//#SuperCollider
		},

		//--tweet0037
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFCub;n=8;Splay.ar(a.ar({|i|pow(i+1,a.kr(1/n,i/n,1/n,1))}!n*150,0,a.kr({|i|pow(i+1,a.kr(i+0.5/n,i/n))}!n).max(0))/4)}, target:target)//#SuperCollider
		},

		//--tweet0038
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({PingPong.ar(LocalBuf(3e4,2).clear,Ringz.ar(CuspN.ar*Impulse.kr([9,8]/12)/9,LFPar.kr(1/[3,2]).range(51,[99,17])*9),0.5)}, target:target)//#SuperCollider
		},

		//--tweet0039
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;Splay.ar({|i|i=i+1;a.ar(a.ar(i)+1**a.ar(2**a.ar(i/500)*(9-i))*a.ar(9*i).exprange(90,2**a.ar(i/20)*800))}!5)/4}, target:target)//#SuperCollider
		},

		//--tweet0041
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({o=SinOsc.ar(1/RunningMax.ar(Sweep.ar(LocalIn.ar(6)),Impulse.ar([1,0.749,6,12,3,4])));LocalOut.ar(o);Splay.ar(o).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0042
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({c=[97,99];l=3**9;a=LocalBuf(l,2).clear;BufWr.ar(Saw.ar(c/5),a,BPF.ar(VarSaw.ar(c),98,0.1)*l);PlayBuf.ar(2,a,1/4,1,0,1)}, target:target)//#SuperCollider
		},

		//--tweet0044
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;Limiter.ar(LeakDC.ar(a.ar(0.11,BRF.ar(a.ar(a.ar(0.12).exprange(1,1e4),2pi),1/a.ar(0.13).range(1,[99,100])))))}, target:target)//#SuperCollider
		},

		//--tweet0045
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;a.ar(a.ar(a.ar(0.11)),a.ar(a.ar(95*a.ar(0.01,0,1,1),0,a.ar(5e-3,0,50),100),a.ar([98,97]),pi+a.ar(5e-4))).tanh}, target:target)//#SuperCollider
		},

		//--tweet0046
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFTri;GVerb.ar(Mix(Limiter.ar(BRF.ar(a.ar(50,1e-4),a.ar(a.ar([1.01,1.0111])*a.ar(8e3)*1e3+4e3,55),a.ar(0.01)*3))))/9}, target:target)//#SuperCollider
		},

		//--tweet0047
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({CombN.ar(Limiter.ar(BRF.ar(LFSaw.ar(10,0,0.01),LFTri.ar([5,6]*0.1))),0.1,LFTri.kr(0.1,0,0.05,0.05).round(0.01))}, target:target)//#SuperCollider#SC2012
		},

		//--tweet0048
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Impulse;b=SinOsc;c=b.ar(0,BRF.ar(a.ar([7,8]),a.ar(9).lag2(1e-3),1.5,2pi));Ringz.ar(c,b.ar(0.02,0,99,150),1/9)+c*0.02}, target:target)//#SuperCollider
		},

		//--tweet0049
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({Splay.ar(SinOsc.ar(9,SinOsc.ar(midicps((Sweep.ar(0,(33..3))%128&(Sweep.ar(0,(3..9))%(LFSaw.ar(3)*9+99)))+33),0,pi)))/3}, target:target)//#SuperCollider
		},

		//--tweet0050
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Saw;b=(2..12);c=0.015;GVerb.ar(Splay.ar(Klank.ar(`[b*50+b,c,c],Hasher.ar(a.ar(b/4pi,a.ar(c)*b+b).ceil)))/9,5.rand+1)}, target:target)//#SuperCollider
		},

		//--tweet0051
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Saw;GVerb.ar(Splay.ar(BBandPass.ar(a.ar("sunday".ascii),a.ar(9/"slow".ascii)*400+500,a.ar(7/"coding".ascii)+1.1)/5))}, target:target)//#SuperCollider
		},

		//--tweet0052
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{Splay.ar(BLowPass.ar(Impulse.ar("sunday".ascii),LFTri.ar(3/"live".ascii)*1800+1900,LFTri.ar(4/"coding".ascii)+1.01))}.play(target:target)//#SuperCollider
		},

		//--tweet0054
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({CombN.ar(SyncSaw.ar(Saw.ar([3,4],32,64),Saw.ar([4,3],99,Duty.kr(1,0,flop(Dseq(2!6++4++3,99)*(4**(0..4))))))/9,1,1/6,2)}, target:target)//#SuperCollider
		},

		//--tweet0055
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Pulse;CombN.ar(Slope.ar(a.ar(a.ar([1,2]/3,1/9,50,[50,150])),a.ar([3,4],1/3)+a.ar([2,3],1/4)/10+0.005).cos/5,1,1/6,2)}, target:target)//#SuperCollider
		},

		//--tweet0056
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({MantissaMask.ar(Pulse.ar(LFPulse.ar(1/8,0,0.55,15,76)+LFSaw.ar([0.1,0.11]),Saw.ar(10)),LFPar.ar(1/16,[0,0.5],3,3),0.7)}, target:target)//#SuperCollider
		},

		//--tweet0058
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({CombN.ar(SinOsc.ar(Saw.ar(3,64,99),Saw.ar([3,4],Saw.ar(1,32,128),Duty.ar(1,0,flop(Dseq([0,8,1,5])*[1,4,8]))))/9,1,1/6)}, target:target)//#SuperCollider
		},

		//--tweet0059
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			a=LFTri;play({CombN.ar(SinOsc.ar(Saw.ar(3,128,128),Saw.ar([3,4],a.ar(a.kr(0.1,0,8,12),0,32,128)).sin)/4,1,1/6,a.kr(1/32)+1)}, target:target)//#SuperCollider
		},

		//--tweet0060
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			a=LFSaw;play({FreeVerb.ar(CombN.ar(VarSaw.ar(a.ar([32,48],0,42*a.ar(1/[16,24]),8),0,a.ar([18,12],0,1/64,1/64)).sin/2,1,1,2))}, target:target)//#SuperCollider
		},

		//--tweet0061
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
				a=Demand;b=SinOsc;play({b.ar(a.ar(t=Saw.ar([9,9.01]),0,Dseq(0!6++500,inf)),b.ar(a.ar(t,0,Dshuf((0..7)*99,inf)).lag(0.04)))/2}, target:target)//#SuperCollider
		},

		//--tweet0062
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({
					a=SinOsc;b=(1..9);Splay.ar(a.ar(b*55).clip(a.ar(2/b,0,0.5),a.ar(3/b,0,0.5,1))*a.ar(b*55+(4/b),0,a.ar(1/b,0,6)).tanh)/5}, target:target)//#SuperCollider
		},

		//--tweet0068
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LocalIn.ar(2);LocalOut.ar(a=Hasher.ar(a.round(LFTri.ar(LFTri.ar(1e-4)/4+1e-3,0,LFTri.ar(1e-3)).round(2e-4))));a*0.45}, target:target)//#SuperCollider
		},

		//--tweet0069
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LocalIn.ar(2);LocalOut.ar(a=Hasher.ar(a.round(LFPar.ar(4e-3).round(3e-3)/3+a)));FreeVerb2.ar(a[0],a[1],0.33,1,1,0.4)}, target:target)//#SuperCollider
		},

		//--tweet0070
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LocalIn.ar(2);LocalOut.ar(a=Hasher.ar(a.round(SinOsc.ar(3.3e-4,a*2pi).round(5e-4))));a/3+CombN.ar(a,1,[1,0.9],3,0.4)}, target:target)//#SuperCollider
		},

		//--tweet0071
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFTri;b=(2..5);Splay.ar(a.ar(abs(a.ar(b/9/9/9).round(a.ar(9-b*99,9-b/9,a.ar(b/9,b/99)))*a.ar(9,0,9-b*99,99*b),b/9)))}, target:target)//#SuperCollider
		},

		//--tweet0072
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Pulse;b=(1..8-1);GVerb.ar(Limiter.ar(Splay.ar(a.ar(abs(a.ar(b,1/8,8-b/8)).round(a.ar(b*8,b/8,a.ar(b))))))/8,8,1,0.8)}, target:target)//#SuperCollider
		},

		//--tweet0073
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Pulse;b=(1..8);CombN.ar(Splay.ar(a.ar(a.ar(b,a.ar(b/9),b*9,b*99+99),1/3,a.ar(b/9+a.ar(1,2/3,8,10)/9)).tanh),1,2/3,4)}, target:target)//#SuperCollider
		},

		//--tweet0074
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Pulse;BLowPass4.ar(a.ar(a.ar(2,0.2,a.ar(3,0.3)*500,[600,606]*a.ar(5))).sin,LFPar.ar(0.07)*4e3+5e3,LFPar.ar(0.1)+1.3)}, target:target)//#SuperCollider
		},

		//--tweet0075
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;b=(1..16)*8;a.ar(a.ar(b).sum+[2,3]+a.ar(1/8)*99*a.ar(b/(a.ar(1/6)*2+2.05),0,4+a.ar(1/8)).reduce('bitOr'))*0.5}, target:target)//#SuperCollider
		},

		//--tweet0076
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;a.ar(a.ar([1,2,4,8]/4*999).sum*50+[2,1]/3,a.ar(60,0,a.ar([1,2]/3)*a.ar(1/8,0,a.ar(1/8)*8)).tanh*a.ar(4)*6)/2}, target:target)//#SuperCollider
		},

		//--tweet0077
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;b=a.ar(a.ar(1/[5,6])+[798,912],a.ar(1/16)*19+99*a.ar([9,8]),a.ar(a.ar(6)*a.ar(0.009)));a.ar([201,301],b).tanh}, target:target)//#SuperCollider
		},

		//--tweet0078
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=GrayNoise.ar;b=(1..9);CombL.ar(a,1,b/Duty.ar(3,0,Dseq([0.5,1,2,3]*99,99)).lag3(1)).mean/2+Ringz.ar(a/99,b*99).mean!2}, target:target)//#SuperCollider
		},

		//--tweet0079
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({Saw.ar((99,111..999),LFSaw.ar(1.1/(1..76))).mean.distort.distort.distort.distort.distort.distort.distort.distort*3.5!2}, target:target)//#SuperCollider
		},

		//--tweet0080
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;b=a.ar(1/3);Duty.ar(SampleDur.ir,0,Dseq([0,1],inf)).bitXor(a.ar(b>0*30+60,0,a.ar(4,0,a.ar([3,2]/9,b*3,9))))/9}, target:target)//#SuperCollider
		},

		//--tweet0082
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFTri.ar(1/9)*0.07+0.0708;CombN.ar(Decay2.ar(Duty.ar(Dseq([1e-4,a/2],inf),0!2,Dseq([-1,0,1,0],inf)),a/9,a)/5,1,1,12)}, target:target)//#SuperCollider
		},

		//--tweet0083
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFCub;Splay.ar({|i|i=i+1;Formant.ar(*Sweep.ar(a.ar(i/[1,2,3])>a.ar(i/9,i/9,1/6,1/3),0.05)*99*i+99*i)*a.ar(0.1/i)}!6)}, target:target)//#SuperCollider
		},

		//--tweet0084
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Saw;Splay.ar(Formant.ar(a.ar((5,7..15)*19)*99+199,a.ar((1,3..13)*29)*199+299,a.ar((3,5..11)*a.ar(3,2,3))*299+399))/3}, target:target)//#SuperCollider
		},

		//--tweet0086
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFNoise2.kr(1/(9..17));Splay.ar(Ringz.ar(BPF.ar(Dust2.ar(a.abs*1e4),a.exprange(99,1e4),1.1-a),(9..1)*99,a+1.1,a)/5)}, target:target)//#SuperCollider
		},

		//--tweet0087
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({BLowPass4.ar(Splay.ar(VarSaw.ar(200*Duty.kr(1/(1..5),0,Dseq(flat({|x|{|y|y+1/(x+1)}!8}!8),inf)))),5e3,LFTri.kr(9)+1.1)}, target:target)//#SuperCollider
		},

		//--tweet0088
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=SinOsc;LPF.ar(LeakDC.ar(a.ar([98,99],a.ar([8,9],a.ar(1/[88,99],0,2pi),pi).lag(a.ar([9,8])),a.ar(1/[8,9])*9)%1),9e3)}, target:target)//#SuperCollider
		},

		//--tweet0089
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({GVerb.ar(Splay.ar(Ringz.ar(Blip.ar(a=[4,14,5,15,6,16,8],LFNoise0.ar(4/a)*99,LFNoise1.ar(4/a).max(0)),a*99,4/a))/6,200)}, target:target)//#SuperCollider
		},

		//--tweet0090
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({FreeVerb.ar(Splay.ar(BBandPass.ar(Blip.ar(b=(1..8)+1,LFTri.ar(1/b)*9e3,LFTri.ar(3/4/b).max(0)),b*999,1/b),2,3),0.3,1)}, target:target)//#SuperCollider
		},

		//--tweet0091
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFPulse;Splay.ar(Pulse.ar((1..10)*a.ar(1/24+a.ar(1/3)*12,0,1/9,a.ar(1/12,0,0.5,9,48)).abs+6).reduce(\mod).softclip)}, target:target)//#SuperCollider
		},

		//--tweet0092
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({Mix(Pan2.ar(Formlet.ar(Dust.ar(b=(1..8)),b*99,b/99,b/9),SinOsc.ar(b),LFSaw.ar(9.5-b,b/9,LFTri.ar(b/5)*4).max(0)).sin)}, target:target)//#SuperCollider
		},

		//--tweet0093
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({x=SinOsc;a=LocalIn.ar(2);z=x.ar([3.1,4.2]+a)-Balance2.ar(a[0],a[1],x.ar(a*x.ar(a)*999));LocalOut.ar(CombN.ar(z/3));z/5}, target:target)//#SuperCollider
		},

		//--tweet0094
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=Blip;b=LFSaw;CombN.ar(a.ar(a.ar(b.ar(1/[9,99])*1e3+4e3,b.ar(1/[23,24])*4+5,b.ar(1/[5,6])+b.ar(1/[8,9])*9)),0.3,0.3)}, target:target)//#SuperCollider
		},

		//--tweet0095
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{|i|a=VarSaw;b=i/8;play({Pan2.ar(a.ar(b*666+a.ar(b+0.03,b),0,b+0.06,a.ar(b+1,0,b+0.1,6+b,7+b)).sin.tanh,a.ar(b+1,b),0.2)}, target:target)}!8//#SuperCollider
		},

		//--tweet0096
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFTri;b=LocalIn.ar;LocalOut.ar(c=Limiter.ar(CombC.ar(a.ar(d=b+1)*a.ar(d*999),1,a.ar((2..5)/3).mean/2+0.5,6)));c/2!2}, target:target)//#SuperCollider
		},

		//--tweet0097
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFTri;b=LocalIn.ar;LocalOut.ar(c=Limiter.ar(CombC.ar(a.ar(400)*a.ar(d=b+2),1,a.ar((2..5)/d/d/d).mean*0.5+0.5)));c!2}, target:target)//#SuperCollider
		},

		//--tweet0098
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			play({a=LFSaw;b=LocalIn.ar;LocalOut.ar(c=Limiter.ar(CombC.ar(a.ar(d=b+3.3*99)*a.ar(a.ar(d/9)*99),2,a.ar(1/d)/2+1,9)));c/2!2}, target:target)//#SuperCollider
		},

		//--tweet0102
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{|i|play({a=DelayC.ar(InFeedback.ar(1-i),8,LFSaw.ar(1e-5*i+1e-4*(LFSaw.ar(0.1)>0),i,4,4));SinOsc.ar(99+[0,a/9],a*pi)/5!2}, target:target)}!2//#SuperCollider
		},

		//--tweet0103
		{
			arg target;
			var a, b, c, d, f, i, l, n, o, t, w, y, x, z;
			{|i|b=SinOsc;play({a=DelayC.ar(InFeedback.ar(1-i),6,b.ar(1e-3*(b.ar(1,i)),i,3,3));b.ar(45+[a/8,a/9]+b.ar(0.123),a*3)/5!2}, target:target)}!2//#SuperCollider
		},

]
	}
}

/*
		//--tweet0104
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFCub;(50..85).midicps.clump(2).collect{|x,y|a.ar(TRand.ar(x,y,Dust.ar(b=a.ar(y/x).exprange(1,5e3))),0,b/5e3)}.mean}, target:target)//#SuperCollider
		},

		//--tweet0105
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;f=InFeedback.ar(0,2);Pan2.ar(a.ar(a.ar(b=(1..9))*b+99,f/(9-b),a.ar(a.ar(b,f))).sum.sin,a.ar(a.ar(2.001)*12))}, target:target)//#SuperCollider
		},

		//--tweet0106
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=InFeedback.ar(0,2);a.ar(9,a.ar(Pitch.kr(Balance2.ar(b[0],b[1],a.ar(12)),execFreq:99).flop[0])+a.ar(3,b,2))}, target:target)//#SuperCollider
		},

		//--tweet0107
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;d=a.ar(12*a.ar(9))%1/4;c=Amplitude.ar(InFeedback.ar(0),d,d)+a.ar(d*d+[32.01,32]);BBandPass.ar(a.ar(0,c*9,c))}, target:target)//#SuperCollider
		},

		//--tweet0108
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay.ar({|i|j=i/700;a.ar(j,a.ar(j*2,a.ar(j*3,a.ar(j*4,a.ar(j*5,InFeedback.ar/99,2pi),2pi),2pi),2pi))}!15)/2}, target:target)//#SuperCollider
		},

		//--tweet0109
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Formant.ar(b=a.ar(a.ar(a.ar(a.ar(0.1)+1.0905*9)/99)*999)*999,c=CombN.ar(b,1,[0.1,0.11]),CombN.ar(c,1,0.19))/3}, target:target)//#SuperCollider
		},

		//--tweet0110
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar({a={LFSaw.kr(0.05.rand2,0,1.0.rand)}!3;BLowPass4.ar(Saw.ar(a@0*250+300,a[2].max(0)),a@1*2e3+2100,0.025)}!99)}, target:target)//#SuperCollider
		},

		//--tweet0111
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay.ar(a.ar(PulseCount.ar(f=InFeedback.ar(0,2).sum)%999+(60,63.0005..99)*a.ar(2**f)*2+[3,4],f>0*f*9)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0113
		{
			arg target;
			var a, b, c, d, o, x, z;
			{|i|play({a=Duty.ar(b=1/24,0,Dseq(Dshuf({b.linrand}!8,16+i),99));Pan2.ar(BPF.ar(Saw.ar(c=a+i+1*99,a*3),c*2,0.6)*5,i/4-1)}, target:target)}!9//#SuperCollider
		},

		//--tweet0114
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFNoise1;BPF.ar(Splay.ar(SinOsc.ar(0,a.ar((999,888..111),a.ar(1/(9..1),a.ar({|i|i+1/(9-i)}!9,99))))/4),1500,a.ar+1)}, target:target)//#SuperCollider
		},

		//--tweet0115
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Pulse;d=Splay.ar(a.ar(Duty.ar(c=a.ar(b=(6..1),b/7.5)/8+1,0,Dseq(b*c+c.lag3(9)*66,inf))))/9;d+GVerb.ar(d.mean,25,25)}, target:target)//#SuperCollider
		},

		//--tweet0116
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({BPF.ar(SinOsc.ar(Duty.ar(1/300,0,Dseq([Dseq([a=1270,b=2225],2e2),Drand([[1070,a],[2025,b]],[1e3,2e3])],inf))),1500,3)}, target:target)//#SuperCollider
		},

		//--tweet0117
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri.ar(1/[8,7]).abs;CombC.ar(Pulse.ar(Duty.ar(a+0.1/9,0,Dseq([Dshuf((1..9)*99,7),3e3],inf)).lagud(*a/6),a),1,a,5)}, target:target)//#SuperCollider
		},

		//--tweet0120
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;CombN.ar(VarSaw.ar(Select.kr(a.kr(1/[7,8])*a.kr(1/9,0,99),(60..79).midicps),0,a.kr(1/[3,4])%1),1,1/[5,6],8)/4}, target:target)//#SuperCollider
		},

		//--tweet0121
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;CombN.ar(a.ar(Select.kr(a.kr(1/[8,7])*a.kr(1/30,0,9),(56,62..98).midicps),0,a.ar(1/[4,3])),1,1/[6,5],9).tanh}, target:target)//#SuperCollider
		},

		//--tweet0122
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPar;BLowPass.ar(a.ar(Select.kr(a.kr(1/[3,4],0,64*a.kr(5)),(60..67).midicps)),a.kr(0.04)+5*500,a.kr(1/[5,6])+1.01)}, target:target)//#SuperCollider
		},

		//--tweet0123
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;a.ar(a.ar(1/[8,12])>0.9+1*[400,404],InFeedback.ar([1,0]).lagud(a.ar(b=1/(1..6)).mean,a.ar(b*1.25).mean)*4pi)}, target:target)//#SuperCollider
		},

		//--tweet0124
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;a.ar(a.ar(4)>0.2+1*[99,98],InFeedback.ar([1,0]).lagud(a.ar(0.1).abs/5,a.ar(a.ar(1/99)).abs)*a.ar([301,303]))}, target:target)//#SuperCollider
		},

		//--tweet0125
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;a.ar(a.ar(1/[8,9])*4+[400,202],CombC.ar(InFeedback.ar([1,0]).lagud(a.ar(1/9)+1/88,a.ar(1/8)+1/99),1,0.08,9))}, target:target)//#SuperCollider
		},

		//--tweet0126
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=HPF.ar(a.ar([1,4/3],HPF.ar((1..9).sum{|x|Pan2.ar(a.ar(1/x)>0.5,a.ar(666/x))},5)),5);GVerb.ar(c,99,9)/7+c/4}, target:target)//#SuperCollider
		},

		//--tweet0127
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;distort(LeakDC.ar(a.ar(LeakDC.ar((1..9).sum{|x|Pan2.ar(a.ar(1/x)>0.51,a.ar(a.ar(x+1)*9.99+1200/x))})*4e3))/9)}, target:target)//#SuperCollider
		},

		//--tweet0128
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;RLPF.ar(LeakDC.ar(a.ar(LeakDC.ar((1..9).sum{|x|Pan2.ar(a.ar(1/x,x/3)>0.3333,a.ar(666/x))})*999)).distort,3e3)}, target:target)//#SuperCollider
		},

		//--tweet0129
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;LeakDC.ar(a.ar(LeakDC.ar((1/[1,2,4,3,9]).mean{|x|Pan2.ar(a.ar(x*9)>0.6,a.ar(a.ar(x/9)+a.ar(x)*666))})%1*4e3))}, target:target)//#SuperCollider
		},

		//--tweet0130
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;LeakDC.ar(a.ar(LeakDC.ar((1/(1,3..9)).mean{|x|Pan2.ar(a.ar(x)<a.ar(x*9),a.ar(a.ar(x/3)*3e3))})%0.5-0.25*2e3))}, target:target)//#SuperCollider
		},

		//--tweet0131
		{
			arg target;
			var a, b, c, d, o, x, z;
			{|k|play({a=SinOsc;Mix({|i|LeakDC.ar(Pan2.ar(a.ar(1/9+i,0,j=a.ar(i+1/99)),a.ar(i+1+k*(j.ceil*39+39),a.ar(k+2),j)))}!9)/3}, target:target)}!2//#SuperCollider
		},

		//--tweet0132
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;HPF.ar(a.ar(HPZ1.ar(Amplitude.ar(InFeedback.ar(0,2)*9,0,a.ar(2)%1/6)*8e3),Decay2.ar(a.ar(0.5005)>0.93)),9)/2}, target:target)//#SuperCollider
		},

		//--tweet0133
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(RLPF.ar(Blip.ar(Duty.ar(1,a.ar(a.ar(1)*9+99),a.ar(7)>(a.ar(12)*0.3+0.6)*8+9),17),(1..12)*99,6e-3))/4}, target:target)//#SuperCollider
		},

		//--tweet0134
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;mean({|i|Ringz.ar(Blip.ar(a.ar(i+1/[3,4])>(a.ar(i+1/8)+1)*25+50,i+[2,3])*a.ar(i+1/50,i/25),i+1*99,0.1)}!50)/5}, target:target)//#SuperCollider
		},

		//--tweet0135
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Pulse;a.ar(a.ar(a.ar(1,b=(1..8)/9,9,8e3),a.ar(2/3,1/9).lag(a.ar(1)*9),a.ar(b/9,0.6,9,99),250),b/(a.ar(4)+4)).mean!2}, target:target)//#SuperCollider
		},

		//--tweet0136
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Pulse;a.ar(a.ar(a.ar(1,b=(1..8)/9,99,9e3),a.ar(b,0.4).lag(2),a.ar(0.2*b,0.1,9,99).lag(1),300),b/(a.ar(4)+4)).mean!2}, target:target)//#SuperCollider
		},

		//--tweet0137
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;b=a.ar(1/64)*8+9;Splay.ar({|i|a.ar(round(a.ar(i+1/32/b,i/40)+1**2*2e3+50,50),0,a.ar(i/16/b,i/48).min(0))}!64)}, target:target)//#SuperCollider
		},

		//--tweet0138
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=a.ar([199.99,200]);BPF.ar(b+DelayC.ar(b+a.ar(399.9),1,a.ar(1/99,[0,0.05])/99),999,0.1,5)};s.scope(2).style=2, target:target)//#SuperCollider
		},

		//--tweet0139
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPar;Splay.ar({|i|Pluck.ar(GrayNoise.ar(a.ar(i=i+1)),a.ar(i/2)%a.ar(i/3/2),1,i*pi/3e3,3,a.ar(i/9,i,0.499,0.5))}!6)}, target:target)//#SuperCollider
		},

		//--tweet0140
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;LFPulse.ar(a.ar(Duty.ar(1/8,0,Dswitch([Dseq((1..8),4),Dseq([60,1,2],[4,3])]/2,Dseq([0,1],99))*99),0,3e3,300))}, target:target)//#SuperCollider
		},

		//--tweet0141
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Mix({|i|BPF.ar(a=Pulse;a.ar(i+[50,a.ar(1/16).lag2(i)+2*99]@@i,a.ar(j=i+1)*a.ar(j)+a.ar(1/12).lag3(10)),j*500)}!8)/3!2}, target:target)//#SuperCollider
		},

		//--tweet0142
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar({|i|HPF.ar(a=Pulse;a.ar(a.ar(i+4/32).lag3(0.1,8-i)+1*99,a.ar(j=i+1)*a.ar(i+8/j)+a.ar(8/j).lag3(8)),50)}!8)/2}, target:target)//#SuperCollider
		},

		//--tweet0143
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({l=LocalBuf(b=1e4,2);{|i|BufWr.ar(a=LFTri.ar(i+1*[8,19.2]),l,a/[i+1]*b)}!3;LPF.ar(PlayBuf.ar(2,l,1/9,1,0,1).clip2,b)/2}, target:target)//#SuperCollider
		},

		//--tweet0144
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({l=LocalBuf(b=3e3).clear;{|i|BufWr.ar(LFTri.ar(i+1*99),l,LFSaw.ar(i).lag(LFSaw.ar(1/9)+1)*b)}!6;PlayBuf.ar(1,l,loop:1)}, target:target)//#SuperCollider
		},

		//--tweet0145
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;l=LocalBuf(b=600,9).clear;BufWr.ar(a.ar(c=(3..11)*3.5),l,a.ar(9/c,c/99)*b);Splay.ar(PlayBuf.ar(9,l,loop:1)/2)}, target:target)//#SuperCollider
		},

		//--tweet0146
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;l=LocalBuf(c=99,20).clear;RecordBuf.ar(a.ar(c=(1..20)),l);GVerb.ar(HPF.ar(IndexL.ar(l,a.ar(c/45)).sum,9)/9,1)}, target:target)//#SuperCollider
		},

		//--tweet0147
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({f=LFCub.ar(_);e=f*16+16;BufWr.ar(PanAz.ar(c=32,f.(4.008),f.(9)),l=LocalBuf(c,c),e.(4));Splay.ar(BufRd.ar(c,l,e.(99)))}, target:target)//#SuperCollider
		},

		//--tweet0148
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({f=LFPar.ar(_);e=f*31+31;BufWr.ar(PanAz.ar(c=64,f.(5.04),f.(3)),l=LocalBuf(c,c),e.(1));Splay.ar(BufRd.ar(c,l,e.(200)))}, target:target)//#SuperCollider
		},

		//--tweet0149
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({f=LFTri.ar(_);e=f*4e3+4e3*f.(1.2).abs;BufWr.ar(f.([3,4]),l=LocalBuf(8e3,2).clear,e.(1/9));COsc.ar(l,99,f.(1/[7,8]))/4}, target:target)//#SuperCollider
		},

		//--tweet0150
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({o=CombC.ar(Limiter.ar(HPF.ar(LocalIn.ar(2),9)+Impulse.ar(1/3,1/[4,5])),4,LFTri.ar(0.02)*1.9+2,9,0.9);LocalOut.ar(o);o}, target:target)//#SuperCollider
		},

		//--tweet0152
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar({|i|Pan2.ar(a.ar(a.ar(b=1.995**i,0.5/b)+(a.ar(2/b,a.ar(b))*999),a.ar(b*1.01)),a.ar(pi/b,2))}!9/4)}, target:target)//#SuperCollider
		},

		//--tweet0153
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=[3,4,8];Splay.ar(Formlet.ar(a.ar(b*99+99),a.ar(b).round(a.ar(0.05).round(1/3))*99+200,1,a.ar(b/6.011)%1)/9)}, target:target)//#SuperCollider
		},

		//--tweet0154
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=(4.002,9..99);mean(Pan2.ar(c=a.ar(b),c))>mean(a.ar(d=1/99)/b)*Splay.ar(a.ar(b%round(a.ar(d/b*8,b,12))*99))}, target:target)//#SuperCollider
		},

		//--tweet0155
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=(1..9).pyramid;LeakDC.ar(Pan2.ar(a.ar(d=6.01/b),a.ar(99*b),a.ar(d)%1)+Ringz.ar(a.ar(d)<d,60,0.07)).sum.tanh}, target:target)//#SuperCollider
		},

		//--tweet0156
		{
			arg target;
			play({b=(1,3.075..16);a=SinOsc;GVerb.ar(Splay.ar(a.ar(1/b,3*a.ar(b*Duty.ar(b,0,Dseq(b+23,inf).midicps).lag(2))).tanh/5),90)}, target:target)//#SuperCollider
		},

		//--tweet0157
		{
			arg target;
			a=SinOscFB;play({LeakDC.ar(Splay.ar(RHPF.ar(PinkNoise.ar(a.ar(b=1/(1..32),b)),a.ar(a.ar(b,b),1.35)+1/b*50,0.009,b))).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0159
		{
			arg target;
			play({a=LFTri;BufWr.ar(a.ar([2.995,4]*99),b=LocalBuf(3e4,2).clear,a.ar([2,6]/99)*3e4);BufRd.ar(2,b,a.ar([6,9.06]/99)*9e3)/5}, target:target)//#SuperCollider
		},

		//--tweet0160
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;c=a.ar([50,99],0.4);RecordBuf.ar(InFeedback.ar(0,2)+c/3,b=LocalBuf(8e4,2).clear);BufRd.ar(2,b,a.ar(c)*6e4)}, target:target)//#SuperCollider
		},

		//--tweet0161
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({c=CombN.ar(InFeedback.ar(0,2),1,1/8,2.4,1.4);LeakDC.ar(SinOscFB.ar(Pitch.kr(c).flop[0]-0.2+(d=c.abs.lag(0.032)),1-d))}, target:target)//#SuperCollider
		},

		//--tweet0162
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;a.ar(Pitch.kr(CombN.kr(InFeedback.ar([1,0]),1,1/[2,3])).flop[0]*a.ar(1/[3,4],0.1,0.3,1.2),a.ar(1/[4,5])/2)}, target:target)//#SuperCollider
		},

		//--tweet0163
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;a.ar(Pitch.kr(CombN.ar(InFeedback.ar([1,0]),4,4,8)).flop[0]*a.ar([6,3],0,a.ar(1.99)/8+0.3,1.2),0,a.ar(1)/2)}, target:target)//#SuperCollider
		},

		//--tweet0164
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;LeakDC.ar(a.ar([1,2],a.ar(Pitch.kr(CombN.ar(InFeedback.ar([1,0]),5,[4.8,4.7])).flop[0]-4)*2pi*a.ar(1/16)))/2}, target:target)//#SuperCollider
		},

		//--tweet0165
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({CombC.ar(BLowPass.ar(Limiter.ar(LeakDC.ar(InFeedback.ar([1,0]))),2e3)+Impulse.ar(0),1,LFTri.ar(1/[6,8])*0.4+0.5)*0.99}, target:target)//#SuperCollider
		},

		//--tweet0166
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;BufWr.ar(a.ar(b=[303,404]),l=LocalBuf(64,2).clear,a.ar(b*a.ar(99/b)));BufRd.ar(2,l,a.ar(b+2)*a.ar(0.01)*12)/4}, target:target)//#SuperCollider
		},

		//--tweet0167
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(Pulse.ar(b=(101,202..1010)/2,RHPF.ar(a.ar(99/b)*0.9%1,a.ar(9/b,b).linexp(0,1,4,1e4),a.ar(5/b)+1.5)))}, target:target)//#SuperCollider
		},

		//--tweet0168
		{
			arg target;
			var a, b, c, d, o, x, z;
			30.do{|i|play({b=13.fib;Resonz.ar(Splay.ar(Blip.ar(i+1/b,19)*ClipNoise.ar),i*[50,60]+400,LFTri.ar(1/[20,30]*i,i/9)/9+0.13)}, target:target)}//#SuperCollider
		},

		//--tweet0169
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({GVerb.ar(Splay.ar(SinOsc.ar(0,Blip.ar(a=(1..5),99)*99,Blip.ar(a+2.5,a).lag2(LFSaw.ar(1/(a+2.25),2/a)+1)))/3,99,6,0.7)}, target:target)//#SuperCollider
		},

		//--tweet0170
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=a.ar(0,a.ar(b=[2,3])*400,a.ar(b/4.1));c+a.ar(b*99*Amplitude.ar(c,0,1/7))+GrayNoise.ar(CombN.ar(c,1,b/3))/2}, target:target)//#SuperCollider
		},

		//--tweet0171
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({b=(1..4);Splay.ar(CombN.ar(SinOsc.ar(1/b,Spring.ar(LFPulse.ar(pi/b),99*b,1.3e-3)*LFTri.ar(0.13/b,0,pi,2pi)),1,1/4,2))}, target:target)//#SuperCollider
		},

		//--tweet0172
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFCub;b=(1..8);sum(CombN.ar(SinOsc.ar(c=2/b,a.ar(ceil(a.ar(c)*a.ar(1/b,0,75)).round(75),0,a.ar(0.1/c)*9)),1,1/5))/9}, target:target)//#SuperCollider
		},

		//--tweet0175
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFPar;play({Out.ar(5,a.ar(1)|a.ar(5)+RLPF.ar(x=Pan2.ar(InFeedback.ar(5),SinOsc.ar(5.5)),3e3,a.ar(1/25)/2+1.7));x*a.ar(99)}, target:target)//#SuperCollider
		},


		//--tweet0178
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=(1..8)+0.505;Splay.ar(a.ar(a.ar(1/(101-b))+1*99|a.ar(a.ar(1/b,1/b,pi,a.ar(1/b)+9)/b,1/b,404,404))*3).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0179
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=(1..5);Splay.ar(a.ar(b*99+round(a.ar(2/b)*40,40),b,a.ar(a.ar(0.5/b),b,a.ar(1/b,b,a.ar(2**b,b,pi)))).asin)/2}, target:target)//#SuperCollider
		},

		//--tweet0180
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;GVerb.ar(a.ar(1+round(a.ar(0.01),c=[1,2]/3)*99*round(a.ar(c/2)+2))*a.ar(a.ar(c))*a.ar(c/4,0,a.ar(1/c)),99)/4}, target:target)//#SuperCollider
		},

		//--tweet0181
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar(Formant.ar(RLPF.ar(Blip.ar(b=[4,0.5,8,16],LFSaw.ar(1/b,0,c=99,c),c,64),c,SinOsc.ar(b,b,0.5,0.6)).midicps,c))}, target:target)//#SuperCollider
		},

		//--tweet0182
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({c=LFTri;mean({|i|Splay.ar([a=Saw.ar(i/98+99),DelayC.ar(a,2,c.ar(i/97+c.ar(i+1/(c.ar(i/96)*2e3+2e3),i/9,9))+1),a])}!9)}, target:target)//#SuperCollider
		},

		//--tweet0183
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({c=SinOsc;mean({|i|Splay.ar({|j|CombC.ar(c.ar(j+1*99),1,c.ar(a=i*2+j/12)/2+0.5)*c.ar(i+j*99+99)*c.ar(a/3)}!8)}!8).tanh}, target:target)//#SuperCollider
		},

		//--tweet0184
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;f={|i|Vibrato.ar(*if(i>0,{[a.ar(1/i)+2*f.(i-1)]},{[(99..96),(1..4),a.ar(0.1)+1,9]}))};Splay.ar(a.ar(f.(10)))}, target:target)//#SuperCollider
		},

		//--tweet0185
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;c=(1..32);Splay.ar(SinOsc.ar(0,BPF.ar(a.ar(pi/c)*8pi*a.ar(c*a.ar(2/c,1/c,8.16,16)),c*99,a.ar(3/c)/3+0.34))/2)}, target:target)//#SuperCollider
		},

		//--tweet0186
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;b=(1..11).rotate(4)*1.011;LeakDC.ar(Splay.ar(Sweep.ar(0,b+999).fold(a.ar(11.11/b)/2-0.5,a.ar(11.1/b)/2+0.5)))}, target:target)//#SuperCollider
		},

		//--tweet0189
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar(Limiter.ar(Formlet.ar((a=LFSaw).ar((b=(1..8))+200),b*a.ar(b/29).round(0.51)+1*99,a.ar(b/9)*0.5+0.50001)/99))}, target:target)//#SuperCollider
		},

		//--tweet0190
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri.ar(b=8/(1..11))%(LFTri.ar(b-3))+2.01;Limiter.ar(Splay.ar(Formant.ar(202*a[0..3],404*a[4..7],606*a[8..11])))/2}, target:target)//#SuperCollider
		},

		//--tweet0191
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(CombN.ar(Blip.ar(a.ar(b=(1..5)).ceil*(a.ar(1/b)*30+60)+99,a.ar(0.2/b).round(1/3)*8+9).tanh,4,4/b,9))}, target:target)//#SuperCollider
		},

		//--tweet0192
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Pulse;c=a.ar(b=[4,1,5,8,3],d=b/9).lag(1/b);Splay.ar(a.ar(b*99*a.ar(b,1/4,1,1.01)|a.ar(d,d,98,99).lag(c%1),c/2+0.5))}, target:target)//#SuperCollider
		},

		//--tweet0193
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(BLowPass4.ar(b=a.ar(a.ar(c=3/(1..12),d=c/3*2,99/c+99,900+c)),c*999+a.ar(c),a.ar(c,d)%1+0.01*2)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0194
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=(2,4..20);CombN.ar(Splay.ar(HPF.ar(a.ar(0,Duty.ar(2/b,0,Dseq(b,inf)).lag2(a.ar(1/b,b)%1)*2pi),9)),1,2/3,4)}, target:target)//#SuperCollider
		},

		//--tweet0195
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;tanh(a.ar(3e-3,DelayC.ar(Ringz.ar(b=InFeedback.ar(1),[9,12],a.ar(c=1/[3,4])+15),1,a.ar(0,b.lag3(1))/9+0.5)))}, target:target)//#SuperCollider
		},

		//--tweet0196
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Normalizer.ar(Splay.ar(a.ar(811+b=(2..8),a.ar((c=a.ar(0.1/b,b))<0*9*b+855+(9/b),a.ar(899/b)*2,2).tanh*6,c)))}, target:target)//#SuperCollider
		},

		//--tweet0197
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;mean({|i|b=a.ar(a.ar(j=i+0.99)/9,a.ar(a.ar(j/99))*9,j*9).tanh;Pan2.ar(a.ar(b.exprange(j*99,j+1*99)+i),b)}!9)}, target:target)//#SuperCollider
		},

		//--tweet0198
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(Ringz.ar(CombN.ar(ClipNoise.ar(a.ar(b=(1..5)/8)>a.ar(0.1,0,1,0.5)),1,b,2),[261,311,349,391,466]))/90}, target:target)//#SuperCollider
		},

		//--tweet0199
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar({|i|SinOsc.ar(c=1/8,LFCub.ar(Duty.ar(b=InFeedback.ar(i%pi)+c,b-c,Dseq(midicps((1..9)*25%32+40),inf)))+i)}!9)}, target:target)//#SuperCollider
		},

		//--tweet0200
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;{|i|play({Pan2.ar(a.ar(i+1/99,i+[1,2]+a.ar(i+1*999)*a.ar([50,74,99]@@i*a.ar(i/9+99,i,i,i))),a.ar(a.ar(i/9)))/11}, target:target)}!9//#SuperCollider
		},

		//--tweet0201
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;HPF.ar(SinOsc.ar(2**Decay.ar(a.ar(c=[2,3]),b=2**a.ar(1/9)-0.5)+99))*BLowPass4.ar(a.ar([261,369]),b+1*5e3,0.2)}, target:target)//#SuperCollider
		},

		//--tweet0203
		{
			arg target;
			var a, b, c, d, o, x, z;
			{|i|play({a=LFPulse;HPF.ar(Ringz.ar(a.ar(a.ar(1/(j=i+1)+a.ar(b=(2..5),0,1/b)*b).sum+1*[89,99]*j),2**i*99,0.42).tanh,9)/5}, target:target)}!4//#SuperCollider
		},

		//--tweet0204
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;c=(2..22)*99;b=999/c;Splay.ar(MoogFF.ar(a.ar(b*99*a.ar(b*9*a.ar(a.ar(b/9)*b))),(d=a.ar(9/c,9/c))+2*c,d+2.99))}, target:target)//#SuperCollider
		},

		//--tweet0208
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay.ar(Formlet.ar(Blip.ar(a.ar(1/(1..9))*400+99,50),(11,22..66)++50++88*10,a.ar(3).abs,a.ar(pi).abs).clip)}, target:target)//#SuperCollider
		},

		//--tweet0209
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;HPF.ar(Normalizer.ar(Splay.ar(Pluck.ar(a.ar(99*b=LFTri.ar(1/c=(1..9))>0+c,1).abs,a.ar(1/b,2).abs)),1,2e-3),12)}, target:target)//#SuperCollider
		},

		//--tweet0210
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({a.ar(0,a.ar(5/3)%1+a.ar(Duty.ar(b=0.15,0,Dseq(a.ar(a.ar(b)/3+0.3).max+1*[[261,440],220,261,349,99,0],inf))))}, target:target)//#SuperCollider
		},

		//--tweet0211
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFCub;play({RecordBuf.ar(InFeedback.ar+a.ar(99),b=Buffer.alloc(s,8e4));TGrains.ar(2,a ar:c=[3,2],b,a.ar(1/c)>0/2+1.5,0,3)}, target:target)//#SuperCollider
		},

		//--tweet0212
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({{|i|RecordBuf.ar(Limiter.ar(HPF.ar(Warp1.ar(1,b=LocalBuf(9e3).clear,c=LFSaw.ar(d=1.0009,i).max,1/d)+(c>0/3),9)),b)}!2}, target:target)//#SuperCollider
		},

		//--tweet0213
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFPar;play({Splay.ar(GrainFM.ar(1,a.ar(9),a.ar((3..7))%1/9,a.ar(1/(2..8))%1*99,(1..9)*99,a.ar(0.22/(4..6))/2+0.5*9)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0214
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;c=a.ar(3**a.ar(1/b=(9..1),b/9));Splay.ar(GrainSin.ar(2,c,a.ar(1/b)%1/9+0.01,2**a.ar(b/99).round*99*b).tanh)/2}, target:target)//#SuperCollider
		},

		//--tweet0215
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;BufWr.ar(a.ar(1),b=LocalBuf(c=7e4).clear,a.ar(1.005)*c);Splay.ar(HPF.ar(BufRd.ar(1,b,a.ar([5,1,2,4])*c),9))/2}, target:target)//#SuperCollider
		},

		//--tweet0216
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Mix(SinOsc.ar(3**Hasher.ar(round(a.ar(0.1)%1,c=(3..1)/16))*(a.ar(c,c)<0*[6,2,1]+[4,[5,5.05],3]*99))).softclip}, target:target)//#SuperCollider
		},

		//--tweet0217
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFSaw;play({Splay.ar(BBandPass.ar(a.ar(3.7*b=1/(1..16),0,a.ar(99+b,0,a.ar(b*c=0.055).max)),4**a.ar(b/8)*99+99,c,20).tanh)}, target:target)//#SuperCollider
		},

		//--tweet0218
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(a.ar(99*(b=a.ar(a.ar(c=1/(1..9))*9)>0.5)/2+Demand.ar(Stepper ar:b,0,Dseq(99/c,inf)).lag3+a.ar(c)))/2}, target:target)//#SuperCollider
		},

		//--tweet0219
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({Splay ar:a.ar(HPF.ar(Ringz.ar(a.ar(b=1/[3,12,4,1,6,2]).lag3(a.ar(2.67**b).abs)*99,a.ar(1/b/9,b)>0*20+99/b)))}, target:target)//#SuperCollider
		},

		//--tweet0220
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({RecordBuf.ar(c=InFeedback.ar,b=Buffer.alloc(s,9e4));HPF.ar(a.ar(99,c*6)/9+TGrains.ar(2,a ar:3,b,c+3,2,12),9)}, target:target)//#SuperCollider
		},

		//--tweet0221
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({tanh((c=InFeedback.ar(0,2))+HPF.ar(a.ar(b=1/[5,4],a.ar(a.ar(b*1.1,a.ar(b*2))+a.ar(b*1.4,c,5,4).ceil*99)),9))}, target:target)//#SuperCollider
		},

		//--tweet0222
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOscFB;play({((c=InFeedback.ar(0,2).lag(b=1/67))+DelayL.ar(HPF.ar(a.ar([99,98]*50.666*a.ar(c+b*b,c),c%2),50),b,b)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0223
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFSaw;play({Splay.ar(BPF.ar(a.ar(f=Duty.ar(a.ar(a.ar(c=3/d=(2..6)))*a.ar(d)/c,0,Dseq(ceil(a ar:d)+d*99,inf))+a.ar(c)),f))}, target:target)//#SuperCollider
		},

		//--tweet0224
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({d=BufRd.ar(2,b=LocalBuf(c=2e5,2).clear,a.ar([2,3]*9)*c,0);BufWr.ar(a.ar(3/[2,3])/3,b,a.ar([99,145]).abs*c);d}, target:target)//#SuperCollider
		},

		//--tweet0225
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=LFSaw;play({b=(1..8)*99;Splay.ar(CombN.ar(Blip.ar(b/2+a.kr(-8/b,1,99),b/4+a.kr(1/b,1,99))*SinOsc.ar(8/b,a.ar(99/b)))).sin}, target:target)//#SuperCollider
		},

		//--tweet0226
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;LocalOut.ar(b=a.ar(0.5,Peak.ar(c=LocalIn ar:2,d=a.ar(9/[2,3]))*a.ar(5e-3)*9));HPF.ar(b+a.ar(0,d.max+c*99),9)}, target:target)//#SuperCollider
		},

		//--tweet0227
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;f=SinOsc;b=a.ar(a.ar(4/3)*4).lag2(0.01);Splay.ar(f.ar(d=lag(99**b*a.ar(c=2/(6..9))))+f.ar(d*b/c,b*d,1-c))/4}, target:target)//#SuperCollider
		},

		//--tweet0228
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay ar:HPF.ar(MoogFF.ar(a.ar(50*b=(0.999..9))-Blip.ar(a.ar(b)+9,b*99,9),a.ar(b/8)+1*999,a.ar(b/9)+1*2),9)/3}, target:target)//#SuperCollider
		},

		//--tweet0229
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;b=(1..9);Splay.ar(CombN.ar(a.ar(b*99*a.ar(b)).reduce('&'),2,2/b,2))+BPF.ar(a.ar(4)*4,a.ar(2)+[1,2]*99,0.12)}, target:target)//#SuperCollider
		},

		//--tweet0230
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay.ar(CombC.ar(PinkNoise.ar(Ringz.ar(LFSaw.ar(b=(1..9)/16),b*999,1.25)),1,1/(b*999)*(LFTri.ar(b/120,b*2)%1),3))/99}, target:target)//#SuperCollider
		},

		//--tweet0231
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(Pluck.ar(a.ar(30*c=(5..7))*a.ar(b=1/[25,14]),a.ar([3,2]),0.02,a.ar(c/66)+1/7,9,a.ar(1/c)%1,3).sin)/2}, target:target)//#SuperCollider
		},

		//--tweet0232
		{
			arg target;
			var a, b, c, d, o, x, z;
			a=SinOsc;play({CombC.ar(a.ar(Duty.ar(1/b=[4,3],0,Dseq(9.fib.pyramid*99,inf)))*a.ar(b/9),1.01,a.ar(b/999).abs+0.01,9).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0233
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(a.ar(Duty.ar(b=1/[1,4,6,8,11],c=a.kr(b/98),Dseq(Select.kr(a.kr(b/99)+c*5,1/b+59),inf).midicps)+c)/2)}, target:target)//#SuperCollider
		},

		//--tweet0234
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;Splay.ar(a.ar((99*b=[1,4,5,8])*lag(a.ar(a.ar(4/b)+a.ar(9-b/9)*50))+b)/2)+Mix(GrayNoise.ar(a.ar(b,0,0.1))/9)}, target:target)//#SuperCollider
		},

		//--tweet0235
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay.ar(a.ar(CompanderD.ar(Duty.ar(c=a.ar(b=(1,3..13),b,b,b),0,Dseq(b,inf)),5,4,3,c)*99,a.ar(b*9)*9,2)).sin}, target:target)//#SuperCollider
		},

		//--tweet0236
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;BufWr.ar(e=a.ar(12/c=1/(9..5)),b=LocalBuf(4e4,5).clear,a.ar(e%c)*1e5,0);Splay.ar(BufRd.ar(5,b,a.ar(1)*1e4,0))}, target:target)//#SuperCollider
		},

		//--tweet0238
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFCub;Splay.ar(Limiter.ar(Formlet.ar(Logistic.ar(3.9,b=(7..4)),a.ar(b)+a.ar(b/7)*800+999,c=a.ar(b/99)%1/50,c*2)/9))}, target:target)//#SuperCollider
		},

		//--tweet0239
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(CombC.ar(a.ar(Duty.ar(b=0.11/(1..6),0,Dseq(" #SuperCollider ".ascii.midicps,inf))),4,a.ar(b/9)%a.ar(b)*4%4,5)/6).tanh}
				target:target)
		},
			//--tweet0240
			{
				arg target;
				var a, b, c, d, o, x, z;
			play({Pan2.ar(CombN.ar(BLowPass4.ar(d=Pulse.ar(Duty.ar(1/[10,4],0,Dseq(" #SuperCollider ".ascii.midicps.pyramid(6),99)).mean)),1,1,8)/2,d)/2}, target:target)
		},

			//--tweet0241
			{
				arg target;
				var a, b, c, d, o, x, z;
				play({a=SinOsc;Splay.ar(a.ar(Shaper.ar(' #SuperCollider '.ascii as:LocalBuf,Blip.ar(0.011,c=(2..4)),a.ar(a.ar(c)>0*a.ar(1/c)>0*99))*c)).tanh}, target:target)
			},

			//--tweet0242
			{
				arg target;
				var a, b, c, d, o, x, z;
				play({a=LFTri;b=Splay.ar(Decay2.ar(a.ar(c=' #SuperCollider '.ascii),a.ar(1/4)%0.2,a.ar(3/c)%1/99,a.ar(3*c)/9).sin)/15;b+GVerb.ar(b,99,4,0.9)}, target:target)
			},

			//--tweet0243
			{
				arg target;
				var a, b, c, d, o, x, z;
				play({a=LFSaw;Splay.ar(a.ar((c=(1..9)/8)**a.ar(c,c,1,a.ar(0.21)%1).reduce('bitXor')*Duty.ar(4,0,Dseq([33,10,40]*9,inf))))/4}, target:target)//#SuperCollider
		},

		//--tweet0244
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw ar:_;sum({|i|Pan2.ar(a.(a.(i+1/99)/9+1.25**i*9+99),a.(i+1/98))}!23)/6+LPF.ar(a.(a.(0.009)*9)>0*a.([50,51]))/4}, target:target)//#SuperCollider
		},

		//--tweet0245
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Pan2.ar(AllpassC.ar(a.ar(1/c=(1..9))>0.9*a.ar((d=a.ar(0.075))>0/3+1*c*99),1,c/9,d*4+4),a.ar(1/c/9)).sum.lag*8}, target:target)//#SuperCollider
		},

		//--tweet0246
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;CombC.ar(DynKlank.ar(`[midicps(a.ar(1/b=(1..9)*1.5)*b+50),2e-4,b/9],e=a.ar(d=[2,3]/.t b)),2,2-LPF.ar(e,50))}, target:target)//#SuperCollider
		},

		//--tweet0248
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(a.ar((b=(d=a.ar(0.1)<0)+(2..8)/(d+2))*99)+Ringz.ar(a.ar(b/2)>0,b*99,5**a.ar(a.ar(0.01)+2-b)/4)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0249
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;b=a.ar([6,5]/2).round(a.ar(1.01))%1;HPF.ar(b+AllpassC.ar(PitchShift.ar(b,1,2,c=0.03),2,a.ar(c,[2,3])/2+1,3),9)}, target:target)//#SuperCollider
		},

		//--tweet0250
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;AllpassC.ar(Mix(a.ar(Latch.ar(a.ar(1.50055,[0,5e-4]!2),a.ar([15,4,2]))*[999,400,150]))/4,3,2-a.ar(0.1,[0,1]))}, target:target)//#SuperCollider
		},

		//--tweet0251
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SyncSaw;GVerb.ar(Limiter.ar(HPF.ar(Mix(a.ar(99*b=(1..8),b*2.01)%a.ar(b/64,a.ar([4,8,14],b/4)+1).max(0)),9))/2,70,4)}, target:target)//#SuperCollider
		},

		//--tweet0253
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=a.ar|a.ar(1,[0,a ar:1e-4],2);Splay ar:HPF.ar(c+CombC.ar(RLPF.ar(c,b=12.fib*112,0.01),3,a.ar(2/b)+2,5)/4,9)}, target:target)//#SuperCollider
		},

		//--tweet0254
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;CombN.ar(a.ar([0,1],a.ar(Duty.ar(c=0.5/b=2.1,0,Dseq(3*' #SuperCollder 0'.ascii,inf)))*a.ar(0.01)*4,a.ar(b,b)<0),1,c*3,9).tanh}, target:target)
		},

		//--tweet0255
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=VarSaw;CombN.ar(tanh(a.ar(99*b=[6,9])*3+a.ar(a.ar(0.39/b)>0+1*50,0,a.ar(1/27),a.ar(1/3)*18)+(a.ar(3)>0*9)),1,1,4)/2}, target:target)//#SuperCollider
		},

		//--tweet0256
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;(c=HPF.ar(a.ar(b=1/16)+a.ar(b/4)+a.ar(b/3)*9|(e=a.ar(b,d=[0,1])*99),9,e/9).sin)+PitchShift.ar(c,b,e>>5%2+1)/3}, target:target)//#SuperCollider
		},

		//--tweet0257
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;a.ar(c=a.ar(a.ar(1.23,4.5),6,7,8.9)+a.ar(0.123,[4,5],67,8))*a.ar(a.ar(1,[2,3],4,5),6)+a.ar([7,8]*9,1/c*23.4)/5}, target:target)//#SuperCollider
		},

		//--tweet0258
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;a.ar(c=a.ar(9.87,6/5,4,[3,2])>a.ar(8/76,5/432,a.ar([7,6],5.4,3,2),1))*a.ar(a.ar(6,5,4,3),2)>a.ar([5,4],3210/c)}, target:target)//#SuperCollider
		},

		//--tweet0259
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay.ar(lag(a.ar(b=RotateN.ar(a.ar(a.ar(a.ar(1/9)>0))*99,DC ar:(1..6)))>a.ar(b/8))*a.ar(b*99)%a.ar(b/99,b))}, target:target)//#SuperCollider
		},

		//--tweet0260
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;RLPF.ar(a.ar(c=Duty.ar(0.1,0,Dseq((0!9++' #SuperCollider '.ascii.midicps).pyramid(10),inf)),a.ar(c.lag(1/[33,99]))*6),3500)/2}, target:target)
		},

		//--tweet0261
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFPulse;CombN.ar(Splay.ar(a.ar(a.ar([1,3])+a.ar(1/[20,30])+a.ar(1/b=[8,9])+a.ar(a.ar(1/12,1/3)*99*b)*(1..5)*50)/2))}, target:target)//#SuperCollider
		},

		//--tweet0262
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=Decay2;CombN ar:a.ar(a.ar(b=(1..6)).sum*9+99,sum(c.ar(t=a.ar(10/b).sum>[1,2]*a.ar)*b),c.ar(t,0.02,0.2))/20}, target:target)//#SuperCollider
		},

		//--tweet0263
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;SelectXFocus.ar(a.ar([9,99]*c=a.ar(9**a.ar(9)*99))*9,a.ar(Sweep.ar(a.ar((1..9)),c)*9e4%9e2),a.ar(1/9)/9).tanh}, target:target)//#SuperCollider
		},

		//--tweet0264
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Saw;GVerb.ar(a.ar(25*b=(8..2))).mean.lag2(c=LFSaw.ar(a.ar([33,99])+2)+1/99)+mean(a.ar(8/b,a.ar(b))|a.ar(c+2)).sin/3}, target:target)//#SuperCollider
		},

		//--tweet0265
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(a.ar(1/99)*sin(LPF.ar(Pulse.ar(2,a.ar(b=a.ar(1e-4)+1/(8..2))),500,a.ar(b/3)+1*8))%sin(a.ar(4))).tanh}, target:target)//#SuperCollider
		},

		//--tweet0266
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;(d=Splay.ar(a.ar(c=a.ar(b=(1..6)/2).div(4/b)+(e=a.ar(b/99)*2+3).round*99)).sin)+a.ar(c*1.5,e/d,0.7/e).mean/2}, target:target)//#SuperCollider
		},

		//--tweet0267
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;z=sum(a.ar(b=9/(1..9),303)*a.ar(b/5-4,2.5));{|i|z=z+AllpassC.ar(z,1,i+1/b/9,a.ar(b/9,2),b/9)}!9;Splay ar:z.sin}, target:target)//#SuperCollider
		},

		//--tweet0268
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar((c=Resonz.ar(a.ar(50.1/b=1/(1..8)),500*d=2**a.ar(b/9),a.ar(-4*b)%1))+PitchShift.ar(c,b,d round:b))/2}, target:target)//#SuperCollider
		},

		//--tweet0269
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=a.ar(5/(1..5)).ceil.lag(c=a.ar(5e-3)%0.05);Splay.ar(a.ar(5**b*((5..1)*50),c*b*5555,1+a.ar(1/50+c)-b)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0270
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;AllpassN.ar(a.ar(98.5+c=(Amplitude.ar(d=InFeedback.ar)<a.ar(f=1/[9,8.9])).lag(f/9)+d,d+f,c),1,f*3,20).tanh}, target:target)//#SuperCollider
		},

		//--tweet0271
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=(a.ar(c=0.015)/9<a.ar(5/(1..7))).varlag(c);Splay.ar(a.ar(2-b**ceil(a.ar(b)*5+6),b)+BrownNoise.ar(b%1)).sin}, target:target)//#SuperCollider
		},

		//--tweet0272
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;HPF.ar(Splay ar:a.ar(TwoPole.ar(a.ar(2**b=(3..8)*(a.ar(0.05).round/4+1))>c=a.ar(1.1/b),b*99,c%0.5+0.5))/2,9)}, target:target)//#SuperCollider
		},

		//--tweet0273
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;HPF.ar((c=Splay.ar(a.ar(b=(19..-9)*50.01)*(1.2**a.ar((1..5)*3/4*(a.ar(1/b).floor*3+1)))&b)%1)+a.ar(9/c),9)/3}, target:target)//#SuperCollider
		},

		//--tweet0274
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay ar:a.ar(Duty.ar(b=1/[1,8,2],0,Dseq(' #SuperCollider '.ascii.pyramid*9**1.0595/2,inf)),a.ar(b)*lag(a.ar(0-b)<0.9)*5e3)/3}, target:target)
		},

		//--tweet0275
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;CombN.ar(a.ar(a.ar(a.ar(1/[2,3])<0+1)**a.ar(1+a.ar(1+a.ar(1/6)*99)*666).lag(a.ar([1.55,1])%1)*99),1,0.9,3)/3}, target:target)//#SuperCollider
		},

		//--tweet0276
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;VOsc3.ar({|i|Buffer.alloc(s,1024).sine1(i+c=(3..1))}!2@0,*c+round(d=a.ar([2,[3,1]]))*(a.ar(d*5)>0)/2*99).tanh}, target:target)//#SuperCollider
		},

		//--tweet0277
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(Blip.ar([60,65,53,67,80].midicps,(b=(1..5))**ModDif.ar(a.ar(1),a.ar(2),a.ar(4))*a.ar(1/b/9)*9)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0278
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay ar:RLPF.ar(a.ar(a.ar(b=1/2**(2..6))>0*3+15/b),pi**a.ar(a.ar(b)+1*b)*999+(a.ar(a.ar(b*9)*9)*99)/2,0.2)/5}, target:target)//#SuperCollider
		},

		//--tweet0279
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay ar:a.ar(CombN ar:DegreeToKey.ar(as(b=[1,3,6,8,10],LocalBuf),a.ar(a.ar(1/b/99)/pi)*12+18+b).midicps)*0.6}, target:target)//#SuperCollider
		},

		//--tweet0280
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay.ar(FBSineC.ar(2**a.ar(pi/b=7.fib).ceil*99*(2**b)%((c=a.ar(b/99)+1)*4e3),c+0.1,a.ar(1/b/20)+1,1.02,7)/3)}, target:target)//#SuperCollider
		},

		//--tweet0281
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFCub;Splay.ar(a.ar(b=2/(2..9))%a.ar(b/5)*a.ar(2**a.ar(b/8)>0+1*2*(b*[300,303]-(a.ar(b/9)>0*50).lag2))*a.ar(b/6,b))}, target:target)//#SuperCollider
		},

		//--tweet0282
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar(AllpassN.ar(a.ar(999*b=1/(a.ar(1/(4..9))>0*[1,4,2,3]+4),a.ar(a.ar(b)>0,b,b)%1).tanh/2,1,b.lag,4))}, target:target)//#SuperCollider
		},

		//--tweet0283
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar(a.ar(a.ar(b=1/(2..6),1)<b*500+99)/5+a.ar(999*b,a.ar(a.ar(b,1)<0.1+1,1)%b,a.ar(0.1-b,1).min(0)))/2}, target:target)//#SuperCollider
		},

		//--tweet0284
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;RHPF.ar(Splay ar:SinOsc.ar(a.ar(c=[6,14,4])%a.ar(c),a.ar(c-1)+1**a.ar(c/9)*4,a.ar(1/c)>0*99),99,0.3).tanh*0.6}, target:target)//#SuperCollider
		},

		//--tweet0285
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;a.ar((b=a.ar(1/3))+1**a.ar(b)*(99+c=[0,1]))%a.ar(b*99,c)%a.ar(1/32)+a.ar(a.ar(b)*4e4%2e3,0,a.ar(6,c)>0.9/2)/2}, target:target)//#SuperCollider
		},

		//--tweet0286
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;GVerb.ar(HPF.ar(a.ar(a.ar(1/4,8).ceil+1*[99,9])*a.ar(1.01,ceil(2**a.ar(1/16)*4))>(a.ar(1/128)/4),9)/9,9,2,0.9)}, target:target)//#SuperCollider
		},

		//--tweet0287
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;HPF.ar(Splay.ar(Saw.ar(midicps(':>AEH.'.ascii-ceil(2**a.ar((1..5)/32))))%a.ar(1!2++6)%a.ar(2,[1,2]/8,2)),9)/2}, target:target)
		},

		//--tweet0288
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar(a.ar(SelectX.ar(a.ar(0.1)%(a.ar(b=(1..4)))*(c=b+8),DC ar:':.UODD.Ed'.ascii.midicps),a.ar(1/c)))/2}, target:target)//#SuperCollider
		},

		//--tweet0289
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({GVerb.ar(sum(SinOscFB.ar(33*b=(1..50),lagud(t=Impulse.ar(b/49),5e-3,0.2)*99,t.lagud(7e-3,1))),299,9,0.01,0.5,6,1,1,1)}, target:target)//#SuperCollider
		},

		//--tweet0290
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;AllpassC.ar(a.ar(b=[99,98],c=a.ar(12))+a.ar(c>0*8*b,0,a.ar(1/b)),1,a.ar(1/[3,4])%1,8,a.ar(1/64,[0,1])*3).sin}, target:target)//#SuperCollider
		},

		//--tweet0291
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Pluck.ar(a.ar(a.ar(1/16)+2*99,0,a.ar([2,3]/4)*6).sin,a.ar([6,4])%a.ar([4,6]),1,a.ar(5/[4,6])%(1/[2,3]),2)/9%1}, target:target)//#SuperCollider
		},

		//--tweet0292
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Saw;RecordBuf.ar(a.ar(d=[2,4,8,3,6])%a.ar(9)/6,b=LocalBuf(3e3,5).clear);Splay.ar(Shaper.ar(b,a.ar(d*32+a.ar(d/8))))}, target:target)//#SuperCollider
		},

		//--tweet0294
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Mix(a.ar({|x|a.ar(x+1/[6,8]).round/2+1*99*{|x|Duty.kr(1/x,0,Dseq(fib(x+1)-1,inf))}.(x+2).lag(0.02)}!8)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0295
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;AllpassC.ar(HPF.ar(reduce(a.ar([600,500,99,50,8/3])*a.ar(0.1/(9..5)),\hypot)/2,9),1,a.ar(1/[80,90])/3+0.5,5)}, target:target)//#SuperCollider
		},

		//--tweet0296
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;HPF.ar(CombN.ar(a.ar(sum({|i|a.ar(2**(1/8)**i,i/8,a.ar(i+8/8))>a.ar(i+[2,3]/88)}!8)*88,a.ar(1/18,1))),8)/3}, target:target)//#SuperCollider
		},

		//--tweet0297
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar({|i|a.ar(1+(c=a.ar(i+1/[6,4])/(a.ar(1/[8,9])+1.5))**i+i*99,d=c%DelayN.ar(c),d.lag3(c%1/99))}!4)/3}, target:target)//#SuperCollider
		},

		//--tweet0298
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({b=XFade2;a=SinOscFB;a.ar(b.ar(a.ar(1).ceil*36,a.ar(2).round*2+4*12,a.ar(1/[4,12]))+8*4,c=a.ar([2,3])%1,c*a.ar(1,1/3))}, target:target)//#SuperCollider
		},

		//--tweet0299
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;b=Formant;b.ar(round(a.ar(1/16),c=3**a.ar([2,3],[0,1]))+3*33*ceil(c),3**c.lag*66,3**c*99)*b.ar(c+3,1-c*3e3)/4}, target:target)//#SuperCollider
		},

		//--tweet0300
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;b=Formant;b.ar(round(a.ar(1/16),c=3**a.ar([2,3],[0,1]))+3*33*ceil(c),3**c.lag*66,3**c*99)+b.ar(c+3,1-c*3e3)/4}, target:target)//#SuperCollider
		},

		//--tweet0301
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay ar:CombN.ar(a.ar(Out.kr(0,b={|i|Duty.kr(i+1/9,0,In.kr(i+1%4)+Dseq(8.fib,inf)%9)}!4);b*99,b*2),1,1/3)/2}, target:target)//#SuperCollider
		},

		//--tweet0302
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=Spring;c=a.ar((4..2)/64)%1;CombN ar:a.ar(0,b.ar(b.ar(b.ar(a.ar([2,3])>0,4,c@0/4),9,c@1/3),24,c@2/3)*9)*0.7}, target:target)//#SuperCollider
		},

		//--tweet0303
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;LocalOut kr:d=a.ar(Duty.kr(LocalIn kr:8,a.kr(1/16,1),Dseq((1..8)*50,inf)),a.kr(1/(1..8))+1/2);Splay ar:d/2}, target:target)//#SuperCollider
		},

		//--tweet0304
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;GVerb.ar(sum(RHPF.ar(a.ar(3.5-b=(8..2),a.ar(4/b)*99)>0*a.ar(b*99)*(9-b),a.ar(1/b/2)+2*666,0.4)).tanh/5,99,2)}, target:target)//#SuperCollider
		},

		//--tweet0305
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay ar:a.ar(Duty.ar(1/b=(2..6),0,Dseq(a.ar(0.1)>0*b+ceil(b*a.ar(3/b))%14*99,inf)),b*b*tanh(a.ar(4/b)*9)|1)}, target:target)//#SuperCollider
		},

		//--tweet0306
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({HPF.ar(FreeVerb.ar({|i|SinOsc.ar(Duty.ar(i+1/9,0,Dseq((1..8).stutter(32),inf)*Dseq(8.fib,inf)*99))}!2,0.2,1,0.2),9)/2}, target:target)//#SuperCollider
		},

		//--tweet0307
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({CombN.ar(Blip.ar(Duty.ar(1/[9,8],0,Dseq(\AVVVF.ascii.midicps,inf)/a=2+Blip.ar(3/[8,9],2).round),c=a**a.lag,c+5)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0308
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({FreqShift.ar(a=Splay.ar(Formlet.ar(Blip.ar(Blip.ar(Blip.ar(2.01,3)>0,b=(1..9))+1,b/8)+2*99,b*50,0.01).tanh),0.01)+a/7}, target:target)//#SuperCollider
		},

		//--tweet0309
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;GVerb.ar(mean(FreqShift.ar(c=a.ar(a.ar(a.ar(99/b=(1..9),1),1/b)+b*50,1),1/b)+c)/3,200,3,0.5,0.5,9,1,0.7,1)}, target:target)//#SuperCollider
		},

		//--tweet0310
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;LocalOut ar:c=a.ar(Duty.ar(Trig.ar(LocalIn ar:2,a.ar(b=1/[3,2])+11/2),0,Dseq((1..8),inf))*99,a.ar(b/12));c}, target:target)//#SuperCollider
		},

		//--tweet0311
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;AllpassC.ar(a.ar(a.ar(8)+3<<a.ar(3/8,0.9,a.ar(5)+1,4.2)*9,a.ar(1/32)+a.ar(7.9,1)),2,a.ar([3,2]/999)+1,4)/2}, target:target)//#SuperCollider
		},

		//--tweet0312
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Pluck.ar(a.ar(99+b=[1,2],1),a.ar(8),1,a.ar(b/16)>0/2+2.5-b/99+(b*a.ar(b,1)>(c=3e-3)/2),2,a.ar(c*b,0.4))/12}, target:target)//#SuperCollider
		},

		//--tweet0313
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;CombN.ar(a.ar(Duty.ar(c=[4,2]/(a.ar([4,1])>0*4+4),0,Dseries()%a.ar(c,c,42)+1*99).lag3(0.025).max(0)),2,2,4)/2}, target:target)//#SuperCollider
		},

		//--tweet0314
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;b=AllpassC;b.ar(b.ar(a.ar(a.ar(0.1)<0/2+1*[99,98],a.ar(3e-3)+1/2),2,a.ar(0.9)/2+1,9),2,a.ar(0.91)/2+1,9)/4}, target:target)//#SuperCollider
		},

		//--tweet0315
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Blip;b=(1..8);Splay.ar(a.ar(a.ar(3.125,b)+a.ar(b/2.45,b)+1*a.ar(8/b,50)+1*99,a.ar(b/pi,b)+b-a.ar(1/4/b,2,4)).sin/2)}, target:target)//#SuperCollider
		},

		//--tweet0316
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Formlet.ar(Formlet.ar(a.ar(a.ar(c=a.ar([1,2]/32)<0+1)>0+c.lag(c)*99),0,a.ar(3-c/[4,3])+1).sin,99,0,0.01).tanh}, target:target)//#SuperCollider
		},

		//--tweet0317
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=VarSaw;Splay ar:a.ar(Select.ar(a.ar(2.01/b=[0,3,7,5,2,9,10]+0.2)*8,(c=a.ar(0.5/b))>0*12+b+48).midicps,0,c%1).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0318
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar(a.ar(13*13*b=(1..3),1/3)*a.ar(b/13,1)/13+a.ar(a.ar(1/(13..3))+133*b,a.ar(b/333,a.ar(b,1)%1)%1))/3}, target:target)//#SuperCollider
		},

		//--tweet0319
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay ar:a.ar(collect(b=(1..8),{|x,i|[x,i+6/6e3+x]})*60,c=a.ar(b/16/16.16)%1,a.ar([3,6],1,c.lag/3).max(0))}, target:target)//#SuperCollider
		},

		//--tweet0320
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=VarSaw;Splay ar:CombC.ar(a.ar(a.ar(1/b=[2,4,9,3]*9)>0+3*b,0,lag(a.ar(b/2e3)+1/2,1)),1.1,round(a.ar(8/b)%1)+0.1,8)/3}, target:target)//#SuperCollider
		},

		//--tweet0321
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=a.ar(b=(1..6)*60,LocalIn.ar(6)*3);LocalOut.ar(Limiter.ar(BPF.ar(c,a.ar(16/b)+3*b),0.66,16/b));Splay ar:c/2}, target:target)//#SuperCollider
		},

		//--tweet0322
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay ar:a.ar(midicps(c=a.ar(12.fib/round(a.ar(1/[2,4])%1+0.125),1)>0*[9,2,3,0,7,5]+55),a.ar(c/999)+1/2)/3}, target:target)//#SuperCollider
		},

		//--tweet0323
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay ar:a.ar(b=(1..7)/7,a.ar(b/77)+1*7**a.ar(777*b,77**a.ar(b+a.ar(b/77,a.ar(b)/7,77*a.ar(b/77,b,b*7)))))/2}, target:target)//#SuperCollider
		},

		//--tweet0324
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Splay ar:HPF.ar(BLowPass.ar(LFTri ar:c=[1,3,5,6],Duty.ar(c+1/16,0,Dseq(LFTri.ar(1/c/8)>0*3+c*99,inf)),1e-3)/12,9).sin}, target:target)//#SuperCollider
		},

		//--tweet0325
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Out.kr(8,c=a.ar(1/4)>0*a.ar(3/4,1,99,199).round(20)+DelayN.ar(In kr:[9,8],2,2)%[72,64]);a.ar(c**2,c.lag%1)}, target:target)//#SuperCollider
		},

		//--tweet0326
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay ar:CombC.ar(a.ar(2**a.ar(1/6**(1..6))*99)*Decay.ar(HPZ1.ar(a.ar(#[2,3])<0),c=a.ar(98)%1/3),2,c.lag+1,6)}, target:target)//#SuperCollider
		},

		//--tweet0327
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;a.ar(0,a.ar(99,9**a.ar(1/8,lagud(a.ar(1/[2,12])<0*2**a.ar(a.ar(3)>0*150),1/50,1/5)*5))+a.ar(1/[6,7]),3).tanh}, target:target)//#SuperCollider
		},

		//--tweet0328
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;Splay ar:a.ar(Slope.ar(SinOscFB.ar((5..1)/2**a.ar(1/(5..9)+1,99*c=a.ar(1/(9..5))).round(1.005)*99,c+1/2)))/2}, target:target)//#SuperCollider
		},

		//--tweet0329
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;LocalOut ar:c=a.ar(99,LocalIn.ar(9)*a.ar((1..9)/99-98,0,a.ar(97/round(a.ar(1/32)+2.2).lag)*pi));Splay ar:c/2}, target:target)//#SuperCollider
		},

		//--tweet0330
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;GVerb.ar(FreqShift.ar(c=a.ar([2,3]/8)%0.5,a.ar(1/[9,5]).round(c>0.125)+1*[3,2]*99).tanh/2,200,9,1,1,9,1,0.1)}, target:target)//#SuperCollider
		},

		//--tweet0331
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({Ringz.ar(c=Spring.ar(TDuty ar:Dseq(b=[3,3,2,2,2,1,2,2,2]/3,inf))/9,50*Duty.ar(c+1/[6,3],0,Dseq(c.lag>0+[2,4]/b,inf)))}, target:target)//#SuperCollider
		},

		//--tweet0332
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;AllpassN.ar(a.ar(2**(a.ar([4,3])>0)*(a.ar(1/16)>0+2*(a.ar(1/[32,48])>0*20+99)),a.ar(1/63.9)+2/3),3,3,60)/3}, target:target)//#SuperCollider
		},

		//--tweet0333
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar({|i|Formant.ar(a.ar(i+1/150).round+1+i*99+a.ar([3,2]),b=i+2*99,b,a.ar(i+1/130).max(0)).tanh}!8)/3}, target:target)//#SuperCollider
		},

		//--tweet0334
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=(9..1)*4.0015;Splay ar:a.ar(0,a.ar(2/b)*3+4**a.ar(a.ar(b/8)/2+(a.ar(1/33)>0+8*b))*6,4**a.ar(1/b,b)).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0335
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;tanh(GrainFM.ar(1,a.ar([0.5,0.6]),16,a.ar(5)*a.ar(0.015)+1*98,round(2**a.ar(4),0.5)*99,2**a.ar(1/[8,9])*8)/2)}, target:target)//#SuperCollider
		},

		//--tweet0336
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({RecordBuf.ar(BPF.ar(Saw.ar((d=LFSaw.ar(1/9))>0+1/3*99)+c=GrainBuf.ar(2,d,24,b=LocalBuf(3e4).clear,-2),99,4).mean,b);c}, target:target)//#SuperCollider
		},

		//--tweet0337
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Formant;Splay.ar(a.ar(a.ar(b=(1..12)/8,b/3.5+80,999-b/9)+3*50,a.ar(b/3,2.5,5)>0+1*300,a.ar(b/5,2,3)>0*1200)/3).tanh}, target:target)//#SuperCollider
		},

		//--tweet0338
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=Pulse;Splay.ar({|i|i=2**i;Formant.ar(*{|j|j+5.5**a.ar(j+0.75/i).lag(0.12)+a.ar(1.3/i,1/3)*99}!3)*a.ar(4/i)}!8).tanh}, target:target)//#SuperCollider
		},

		//--tweet0339
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(Formant.ar(*[2**round(a.ar(b=1/(1..12)),a.ar(8,b)<0/4+1),4**a.ar(b/12)+2,3**a.ar(b/4)*3]*99)/2).tanh}, target:target)//#SuperCollider
		},

		//--tweet0340
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;AllpassN ar:a.ar(midicps(Duty.ar(c=a.ar(1/[12,8])+3/24,0,Dseq([0,8,5,1,5,4,5]*round(c*18),inf))+60),c*2)/2}, target:target)//#SuperCollider
		},

		//--tweet0341
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;e=a.ar(2**a.ar(1/5)).round(a.ar(1/8)/3);GVerb.ar(HPF.ar(SinOsc.ar(e**[99,150],BPF.ar(e%1,500))/6,9),99,5,0.1)}, target:target)//#SuperCollider
		},

		//--tweet0342
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay ar:SinOscFB.ar(round(2**a.ar(b=(1..8)/128)*256,64),c=a.ar(b)%1,RLPF.ar(a.ar(1/b/32),500,1.01-c)).clip/2}, target:target)//#SuperCollider
		},

		//--tweet0343
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay ar:a.ar(4**a.ar(b=0.01/(2..6))*99,c=a.ar(1-b*8,1/2)+1/2,Decay.ar(c>0.99512*a.ar(c+1/b),1/2)/22).tanh}, target:target)//#SuperCollider
		},

		//--tweet0344
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;a.ar(RLPF.ar(a.ar(9+c=1.1**a.ar([6,8]),a.ar(c/9)%a.ar(a.ar(c/14)*999))>0.99*999,c/4+1*99,a.ar(c/9)/19+0.06))}, target:target)//#SuperCollider
		},

		//--tweet0345
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;Splay.ar({|i|a.ar(1+i).max(c=a.ar(8-i/8))*a.ar(a.ar(i-2.1)%a.ar(9,1)+(a.ar(1)>0/3+1.83)**i+99,c+1/4)}!8)/2}, target:target)//#SuperCollider
		},

		//--tweet0346
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOscFB;c=a.ar(1-a.ar(1/[3,2]).round(0.5)+InFeedback.ar(0,2));a.ar(2**a.ar(1-c).round(1-c)*400,c.abs,c.lag*c).tanh}, target:target)//#SuperCollider
		},

		//--tweet0347
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar({|i|VarSaw.ar(round(a.ar(c=i/48)*a.ar(b=c/72)*8+9,i%9+1)*25+c,c,a.ar(3,i)+1/3,a.ar(b,i/pi)%1)/2}!30)}, target:target)//#SuperCollider
		},

		//--tweet0348
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=VarSaw;Splay ar:AllpassC.ar(9**(c=a.ar(0.1/b=[9,4,3,6]/4)+1/9)*a.ar(round(a.ar(c/3)+b,b)*99,0,c),1,c+9/99,9).tanh/2}, target:target)//#SuperCollider
		},

		//--tweet0349
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;b=Duty;c={Dseq([5,1,3,2],1/0)};a.ar(b.ar(e=1/[8,4],0,c.()*b.ar(e/4,0,c.()))*b.ar(1/e,0,c.()*28.8))*a.ar(e/9)}, target:target)//#SuperCollider
		},

		//--tweet0350
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay ar:CombN.ar(GVerb.ar(a.ar(a.ar(b=(9..1)/99,b)+1*99,b,a.ar(a.ar(b)>b)>0.9),99,1,b*9,b)/19,1,b/9.9,9,0.9)}, target:target)//#SuperCollider
		},

		//--tweet0351
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({LocalOut.ar(b=HPF.ar(Saw.ar([50,99],9e3**lag(Saw.ar([9,8])+LocalIn.ar(2),LFTri.ar(1/[19,18])/19+0.09)).cos,9));b.tanh}, target:target)//#SuperCollider
		},

		//--tweet0352
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=SinOsc;c=a.ar(999**(a.ar(3)*a.ar([3,1]/8)%1),a.ar(0.03,a.ar(98)*a.ar(0.02,[0,1],3),4));c+a.ar(99,c*a.ar(0.01)*12)/3}, target:target)//#SuperCollider
		},

		//--tweet0353
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;sum({|i|AllpassN.ar(RHPF.ar(Saw.ar(a.ar(1/[99,100]).round(1/8)**2*8),2**i*[99,50],0.01),1,i+1/9,9)/9}!8).tanh}, target:target)//#SuperCollider
		},

		//--tweet0354
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;c=Klank.ar(`[[12,4,3,9,10]*2*99],a.ar(5*b=[1,9/8]),b)*d=a.ar(b/8);a.ar(b*2).sum<0*SinOscFB.ar(b*99,d+1/2)+c/2}, target:target)//#SuperCollider
		},

		//--tweet0355
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFSaw;Splay.ar(MoogFF.ar(a.ar(a.ar(9,2/b=(1..9)))>0.05*GrayNoise.ar(999)*a.ar,2**a.ar(b/3.55).round*b*99,3.5)).tanh}, target:target)//#SuperCollider
		},

		//--tweet0356
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay ar:BHiPass4.ar(BLowPass4.ar(a.ar(b=[4,16,3])*a.ar(b*b),8**a.ar(b/50).round*99),3**a.ar(1/b)*99,0.1).sin}, target:target)//#SuperCollider
		},

		//--tweet0357
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=VarSaw;HPF.ar(BLowPass4.ar(a.gar((a.ar([7,6])<0+b=a.ar(c=1/[31,23]))>1+1*99,0,1-b/2)%b,4**a.ar(c)*666,0.08).sin/2,9)}, target:target)//#SuperCollider
		},

		//--tweet0358
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay ar:Pulse.ar(fold((2..5)/(a.ar(0.1)>0+2)**a.ar(b=a.ar(2/(9..7))).ceil.lag*99*[3,1,8,2,4],9,999),2-b/5)/2}, target:target)//#SuperCollider
		},

		//--tweet0359
		{
			arg target;
			var a, b, c, d, o, x, z;
			play({a=LFTri;Splay ar:Pulse.ar(wrap((1..4)/(a.ar(2/3)<0+3)**a.ar(b=a.ar(1/[4,3])).ceil.lag*99*[2,3,4,8,1],20,1e3),2-b/3)%1}, target:target)//#SuperCollider
		}


		]
	}
}
*/