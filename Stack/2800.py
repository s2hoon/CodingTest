from itertools import combinations
w = list(input())
stack = []
com = []
for idx, item in enumerate(w):
    if item == "(":
        stack.append(idx)
    elif item == ")":
        com.append((stack.pop(),idx))

ans = []
for i in range(1,len(com)+1):
    list = combinations(com, i)
    for item in list:
        ans.append(item)

f_ans = []
for item in ans:
    noneed = []
    for k in item:
        a, b = k
        noneed.append(a)
        noneed.append(b)
    temp = []
    for i in range(len(w)):
        if i in noneed:
            continue
        else:
            temp.append(w[i])
    f_ans.append(''.join(temp))


tt = sorted(set(f_ans))

for item in tt:
    print(item)


