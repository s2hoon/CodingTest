word = input()

# 최댓값
big = ""
for i in range(len(word)):
    if "K" in word[i:]:
        if word[i] == "K":
            big += str(5*(10**(i-len(big))))

    else:
        big+= str(1*10**(i-len(word)+1))

print(big)


# 최솟값
small = ""
for i in range(len(word)):
    if word[i] == "M" and i >0 and word[i-1]=="M":
        small +="0"
    elif word[i] == "M" :
        small +="1"
    else:
        small +="5"
print(small)



