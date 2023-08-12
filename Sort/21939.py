import sys
import heapq
N = int(sys.stdin.readline().strip())
question = {}
max_heap = []  # 추천이 높은 문제를 저장하는 최대 힙
min_heap = []   # 추천이 낮은 문제를 저장하는 최소 힙
for i in range(N):
    P, L =  map(int,sys.stdin.readline().strip().split())
    question[P] = L
    heapq.heappush(max_heap, (-L,-P)) # 추천이 높은 문제를 최대 힙에 추가
    heapq.heappush(min_heap, (L,P))    # 추천이 낮은 문제를 최소 힙에 추가

M = int(sys.stdin.readline().strip())

for i in range(M):
    command = sys.stdin.readline().strip().split()
    if command[0] == "recommend":
        if command[1] == "1":
            print(heapq.heappop(recommend_high))

        elif command[1] == "-1":
            print(heapq.heappop(recommend_low))

    elif command[0] == "add":
        P = int(command[1])
        L = int(command[2])
        question[P] = L
        heapq.heappush(max_heap, (-P, -L))
        heapq.heappush(min_heap, (P, L))

    elif command[0] == "solved":
        del question[command[1]]


