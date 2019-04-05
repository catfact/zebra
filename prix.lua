--- tweets

engine.name = 'RedFrikTweets'

function init() end

local t1 = 1
local t2 = 2

key = function(n,z)
  if z > 0 then 
    if n == 2 then
      t1 = t1 - 1
      if t1 < 0 then t1 = 70 end
      engine.tweet(1, t1)
      redraw()
    end
    if n == 3 then
      t1 = t1 + 1
      if t1 > 70 then t1 = 1 end
      engine.tweet(1, t1)
      redraw()
    end
  end
end

redraw = function()
  screen.clear()
  screen.move(20, 20)
  screen.text("t1 "..t1)
  screen.move(40, 20)
  screen.text("t2 "..t2)
  screen.update()
end