word = input()

# 최댓값
big = ""
for i in range(len(word)):
    if "K" in word[i:]:
        if word[i] == "K":
            big += str(5 * (10 ** (len(word) - i - 1)))
    else:
        big += str(1 * (10 ** (len(word) - i)))

print(big)

# 최솟값
small = ""
for i in range(len(word)):
    if i > 0 and word[i] == "M" and word[i - 1] == "M":
        small += "0"
    elif word[i] == "M":
        small += "1"
    else:
        small += "5"
print(small)
