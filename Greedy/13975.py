import sys
import heapq

T = int(sys.stdin.readline().strip())

for i in range(T):
    N = int(sys.stdin.readline().strip())
    num = list(map(int,sys.stdin.readline().strip().split()))
    heapq.heapify(num)
    result = 0
    while(len(num)!=1):
        a = heapq.heappop(num)
        b = heapq.heappop(num)
        heapq.heappush(num, a + b)
        result += (a+b)
    print(result)



