from collections import deque

N ,K = map(int, input().split())
visited = [0 for i in range(100002)]

def BFS(start):

    queue =deque()
    queue.append(start)

    while queue:
        #큐에서 제거
        v =queue.popleft()
        #동생에게 도착했다면
        if v == K:
            #시간 return
            return visited[v]


        #모든 경우에 대해서
        for nextv in (v-1 ,v+1, 2*v):
            #방문안했었다면, 범위내에서
            if 0 <= nextv <= 100000 and visited[nextv] == 0:
                #시간증가
                visited[nextv] = visited[v] +1
                #큐에 추가
                queue.append(nextv)

print(BFS(N))


