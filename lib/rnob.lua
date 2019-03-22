-- build a JI rate knob that goes through zero
local dust = '/home/emb/dust'
local ji = dofile(dust..'/emb/lib/ji.lua')

-- the gamut
local gam = ji.partch()
n = #gam

print("gamut size: "..#gam)

-- multiply index by float, return pair
gam.fmul = function(i,f) return { f*gam[i][1], gam[i][2] } end
-- divide index by float, return pair
gam.fdiv = function(i,f) return { gam[i][1], gam[i][2]*f } end
-- multiply scale index by pair, return pair
gam.mul = function(i, p) return { p[1] * gam[i][1], p[2] * gam[i][2] } end
-- get float for index
gam.f = function(i)
   if gam[i][2] == 0 then return 0
   else return gam[i][1] / gam[i][2] end
end

local octa = 3 -- octaves above
local octb = 3 -- octaves below

local r = 0 -- current ratio
local o = nil -- current octave
local i = 0 -- current index

local pval = {} -- list of positive values

local plo = 2 ^ (-1 * octb) -- positive lower bound
local phi = 2 ^ (octa) -- positive upper bound

--[[
--- add from zero
while i < n do
   i = i + 1
   -- TODO: linear portion?
------- actually i don't think we need this? hm
end 
--]]

-- generating 

o = -1 * octb
while o < octa do
   print("octave: " .. o)
    i = 0
    while i < n do
       i=i+1
       --print(i)
       if (o<0) then 
	  pval[#pval + 1] = gam.fdiv(i, 2^(-1*o))	  
       else
	  pval[#pval + 1] = gam.fmul(i, 2^o)
       end
    end
    o = o + 1
end 

pval[#pval + 1] = { phi, 1};

-- build bipolar values
local bval = {}

i = #pval
print("negative...")
while i > 0 do
   --print(i)
   bval[#bval + 1] = {pval[i][1] * -1, pval[i][2]}
   i=i-1
end 

----- ZERO
bval[#bval+1] = {0,1}

i = 0
print("positive again...")
while i < #pval do
   i = i + 1
   bval[#bval + 1] = pval[i]
end

print("done.")

pval = nil
local nob = {}
for k,v in pairs(bval) do
   nob[k] = { v[1], v[2], v[1]/v[2] }
   -- print (""..k.."\t"..v[1].."/"..v[2].."\t = "..v[1]/v[2])
end

bval = nil
return nob