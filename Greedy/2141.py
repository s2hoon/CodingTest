import sys
N = int(sys.stdin.readline().strip())
arr = []
total = 0
for i in range(N):
    x, a = map(int, sys.stdin.readline().strip().split())
    arr.append((x,a))
    total += a

arr.sort(key= lambda x: x[0])

cnt = 0
for item in arr:
    x, a = item
    cnt += a
    if cnt >= total/2:
        print(x)
        break




