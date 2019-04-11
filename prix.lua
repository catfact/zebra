--- tweets

engine.name = 'RedFrikTweets'

local t1 = 1
local t2 = 2

local tweets = {}

function init()
  local parse_engine_tweets = util.os_capture("cat " .. _path.code .. "zebra/lib/Engine_RedFrikTweets.sc | grep SuperCollider | sed -e 's/^[[:space:]]*//'", 1)
  tweets = tab.split(parse_engine_tweets, '\n')
end

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
  screen.text("t1 ", t1)
  screen.move(50, 20)
  screen.text("t2 ", t2)
  screen.move(0,30)
  screen.text(tweets[t1]:sub(1,math.ceil(#tweets[t1]/2)))
  screen.move(0,40)
  screen.text(tweets[t1]:sub(math.ceil(#tweets[t1]/2),-1))
  screen.update()
end
