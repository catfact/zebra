~tweets = [
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

];

~set = { arg i;
	~group.free;
	~group = Group.new;
	~tweets[i].value(~group);
};


~set.value(~tweets.size.rand);


~cleanup = { ~group.free; }