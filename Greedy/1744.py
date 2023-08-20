N = int(input())
numbers = []
for i in range(N):
    numbers.append(int(input()))
numbers.sort()

plus = []
minus = []
young = []

ans = 0
for item in numbers:
    if item <= 0:
        minus.append(item)
    elif item > 1:
        plus.append(item)
    else:
        ans += item


# 양수 부분
if len(plus) % 2 == 0:
    for i in range(0,len(plus)-1,2):
        ans += (plus[i]* plus[i+1])

else:
    for i in range(1, len(plus)-1,2):
        ans+= (plus[i]* plus[i+1])
    ans += plus[0]

# print(ans)


# 음수 부분
if len(minus) % 2 == 0:
    for i in range(0, len(minus)-1,2):
        ans +=(minus[i]*minus[i+1])
else:
    for i in range(0,len(minus)-2,2):
        ans+=(minus[i]*minus[i+1])
    ans+= minus[-1]

print(ans)
