
local gc = {}

-- ptolemaic, minor, pentatonic kinda thing 
gc.rates = {
    -2, -3/2, -4/3, -1
    -1/2, -3/5, -2/3,
    1/2, 3/5, 2/3,  
    1, 6/5, 4/3, 3/2, 9/5, 2
}

gc.set_rate = function(v, r) 
    gc.state.rate[v] = r
    local rate = gc.rates[r]
    print('set rate: '.. rate)
    softcut.rate(v, rate)
end 

--- loop points
gc.loop = {{1, 5}, {6, 11}, {12, 17}, {18, 24}}
gc.reset = function(v) 
    print('reset ' .. v)
    softcut.position(v, gc.loop[v][1])
end

gc.state = { 
    rate = {11, 11, 11, 11},
    level = { 0, 0, 0, 0},
    freeze = { 0, 0, 0, 0},
    feed = { 
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
    }
}

gc.tog_level = function(v) 
    if gc.state.level[v] > 0 then gc.state.level[v] = 0
    else gc.state.level[v] = 0.5 end
    softcut.level(v, gc.state.level[v])
end 

gc.tog_freeze = function(v) 
    if gc.state.freeze[v] > 0 then gc.state.freeze[v] = 0
    else gc.state.freeze[v] = 0.5 end
    softcut.pre_level(v, gc.state.freeze[v])
    softcut.rec_level(v, 1 - gc.state.freeze[v])
end 

gc.tog_feed = function (v, w)
    if gc.state.feed[v][w] > 0 then gc.state.feed[v][w] = 0
    else gc.state.feed[v][w] = 0.125 end
    softcut.level_cut_cut(v, w, gc.state.feed[v][w])
end 

gc.handle_grid_key = function(x, y, z)
    print('grid_key', x, y, z)
    local v
    if z > 0 then
        if y < 5 then
            v = y
            gc.set_rate(v, x)
        else
            v = y - 4
            if x == 1 then
                gc.tog_level(v)
            elseif x == 3 then
                gc.tog_freeze(v)
            elseif x >= 5 and x <= 8 then
                gc.tog_feed(v, x-4)
            elseif x == 16 then
                gc.reset(v)
            end
        end
        gridredraw()
    end
end

gc.draw_grid = function (g)
    print('gc.draw_grid')
    g:all(0)
    for y = 1,4 do
        -- top 4 rows:
        -- draw current rate index for each voice
        for x=1,16 do
            if gc.state.rate[y] == x then
                g:led(x, y, 12)
            else
                g:led(x, y, 0)
            end
        end 
        -- bottom 4 rows:
        --- 1st column: level
        if gc.state.level[y] > 0 then 
            g:led(1, y+4, 12)
        else 
            g:led(1, y+4, 2)
        end

        --- 3rd column: freeze
        if gc.state.freeze[y] > 0 then 
            g:led(3, y+4, 12)
        else 
            g:led(3, y+4, 2)
        end


        --- columns 5-8: feed
        for j=1,4 do
            if gc.state.feed[y][j] > 0 then 
                g:led(4+j, y+4, 12)
            else 
                g:led(4+j, y+4, 2)
            end
        end
    end
    g:refresh()
end 

gc.init = function()
        
    ---- initial state

    -- cut global
    audio.level_cut(1.0)
    audio.level_adc_cut(1.0)
    audio.level_ext_cut(1)

    local cut_pans = {0.125, 0.25, 0.5, 0.75, 0.875} --{ -0.5, -0.25, 0.25, 0.5 }

    --- cut voices
    for i=1,4 do
        softcut.rec_offset(i, -0.06)
        softcut.level(i, 0.0)
        softcut.rec(i, 1)
        softcut.play(i, 1)

        softcut.level_input_cut(1, i, 1.0)
        softcut.level_input_cut(2, i, 1.0)
        softcut.pan(i, cut_pans[i])
        softcut.filter_dry(1, 1.0);
        softcut.filter_fc(1, 900 + (300 * i));
        softcut.filter_lp(1, 0.5);
        softcut.filter_bp(1, 0.25);
        softcut.filter_rq(1, 20.0);

        softcut.rec_level(i, 1.0)
        softcut.pre_level(i, 0.5)
        
        softcut.loop_start(i, gc.loop[i][1])
        softcut.loop_end(i, gc.loop[i][2])

        softcut.fade_time(1, 0.25)
        softcut.loop(i, 1)


        softcut.position(i, gc.loop[i][1])

        for j=1,4 do
            softcut.level_cut_cut(i, j, 0)
        end


        softcut.enable(i, 1)
    end

    softcut.buffer(1, 1)
    softcut.buffer(2, 2)
    softcut.buffer(3, 1)
    softcut.buffer(4, 2)

    softcut.buffer_clear()

end

return gc