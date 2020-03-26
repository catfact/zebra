--- scrawp
---
--- wrap supercollider scripts
--- no control connection, but scripts can create them
---
--- K2: something
--- K3: something else

local e = engine
e.name = 'Scrawp'

-- current directory for scripts
cwd = norns.state.path..'lib/'
current_script = ''

run = function(script)
   e.script(cwd..script)
   current_script = script
   redraw()
end

init = function()
   run('a.scd')
end

key = function(n,z)
   if z > 0 then
      if n == 2 then run('b.scd') end
      if n == 3 then run('c.scd') end
   end
end

local s = screen
function redraw()
   s.clear()
   s.move(0, 10)
   s.text(current_script)
   s.update()
end
