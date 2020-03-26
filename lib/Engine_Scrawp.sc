ScriptWrapper {
	// sandboxed global environment for scripts
	var env;

	newEnv {
		// push a new sandbox environment
		env = Environment.make {
			// scripts should define this
			// if they need to free resources
			~cleanup = {
			}
		};
		Environment.push(env);
	}

	freeEnv {
		if (env.notNil, {
			Environment.pop();
		});
	}

	runScript { arg path;
		var fn;

		postln("running: " ++ path);
		
		this.finishScript;
		this.newEnv;
		fn = File.readAllString(path.asString.standardizePath).compile;
		fn.value;
	}

	runChunk { arg txt;
		var fn = txt.compile;
		fn.value;
	}

	finishScript {
		// if script defines "~cleanup" function, run it
		if (~cleanup.notNil, {
			if (~cleanup.class == Function) {
				~cleanup.value;
			}
		});
		// pop our environment, restoring the saved one
		this.freeEnv;
	}
}

//---------------
//-- norns interface

Engine_Scrawp : CroneEngine {
	var sw;
	
	alloc {
		sw = ScriptWrapper.new;		
		
		this.addCommand("script", "s", { arg msg;
			sw.runScript(msg[1]);
		});
		
		this.addCommand("chunk", "s", { arg msg;
			sw.runChunk(msg[1]);
		});

		this.addCommand("clear", "", { arg msg;
			sw.finishScript;
		});
		
	}

	free {
		sw.finishScript;		
	}
}