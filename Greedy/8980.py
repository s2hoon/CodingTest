import sys
from collections import defaultdict
N, C = map(int, sys.stdin.readline().strip().split())
M = int(sys.stdin.readline().strip())
boxs = []
for i in range(M):
    boxs.append(list(map(int,sys.stdin.readline().strip().split())))


boxs.sort(key= lambda x : (x[1],x[0]))
print(boxs)
ans = 0
village = [ 0 for i in range(N+1)]

for box in boxs:
    start, end , num = box

    for i in range(start, end):
        num = min(num, village[i] - num)

    for i in range(start, end):
        village[i] += num
    ans += num


print(ans)