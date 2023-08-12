import heapq
import sys

N = int(sys.stdin.readline().strip())
arr = []
for i in range(N):
    s, t = map(int, sys.stdin.readline().strip().split())
    arr.append((s,t))

arr.sort()

room = []
heapq.heappush(room, arr[0][1])

for i in range(1, N):
    # 끝난게 있다면
    if arr[i][0] >= room[0]:
        heapq.heappop(room)
        heapq.heappush(room,arr[i][1])
        
    # 끝난게 없다면
    else:
        heapq.heappush(room, arr[i][1])

print(len(room))
    