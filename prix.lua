--- tweets

engine.name = 'RedFrikTweets'

function init() end

local t = { 1, 2 }
local mod = { {80,80}, {80,80}}

local target = 1

local inc_t = function(i,z)
  t[i] = t[i] + z
  if t[i] > 50 then t[i] = 50 end
  if t[i] < 1 then t[1] = 1 end
  engine.tweet(i,t[i])
  redraw()

end

local inc_mod = function(i,z)
  mod[i] = mod[i] + 1
  if mod[i] > 100 then mod[i] = 100 end
  if mod[i] < 1 then mod[1] = 1 end
  engine.mod(i,mod[i])
  redraw()
end 

key = function(n,z)
  if n == 1 then
    target = z + 1
  elseif n == 2 then 
    if z > 0 then
      inc_t(target, -1)
    end
  elseif n == 3 then
    if z > 0 then
      inc_t(target, 1)
    end
  end
end

enc = function(n,z) 
  if n == 1 then
    -- change volume?
  elseif n == 2 then 
    if z > 0 then
      inc_mod(target, -1)
    end
  elseif n == 3 then
    if z > 0 then
      inc_mod(target, 1)
    end
  end
end

redraw = function()
  screen.clear()
  screen.move(20, 20)
  screen.text("t1 "..t[1])
  screen.move(40, 20)
  screen.text("t2 "..t[2])
  screen.update()
end