N = int(input())
ans = abs(100 - N) #다고장일경우
M = int(input())
if M: # 고장난게 있을 경우만 인풋을 받음
    broken = set(input().split())
else:
    broken = set()


for num in range(1000001):
    for k in str(num):
        if k in broken:
            break
    else:
        ans = min(ans, len(str(num)) + abs(num - N))

print(ans)