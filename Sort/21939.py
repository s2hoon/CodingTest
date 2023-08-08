import sys
import heapq
N = int(sys.stdin.readline().strip())
question = {}
max_heap = []  # 추천이 높은 문제를 저장하는 최대 힙
low_heap = []   # 추천이 낮은 문제를 저장하는 최소 힙
for i in range(N):
    a, b =  map(int,sys.stdin.readline().strip().split())
    question[a] = int(b)
    heapq.heappush(max_heap, (-b,-a)) # 추천이 높은 문제를 최대 힙에 추가
    heapq.heappush(low_heap, (b,a))    # 추천이 낮은 문제를 최소 힙에 추가

M = int(sys.stdin.readline().strip())

for i in range(M):
    command = sys.stdin.readline().strip().split()
    if command[0] == "recommend":
        if command[1] == "1":
            print(heapq.heappop(recommend_high))

        elif command[1] == "-1":
            print(heapq.heappop(recommend_low))

    elif command[0] == "add":
        question[command[1]] = command[2]
        heapq.heappush(recommend_high, (-int(command[2]), -int(command[1])))
        heapq.heappush(recommend_low, (int(command[2]), int(command[1])))

    elif command[0] == "solved":
        del question[command[1]]


