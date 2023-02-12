#string[start:end:step] 
from collections import deque

N ,K = map(int, input().split())
visited = [0 for i in range(100002)]
node = [0 for i in range(100002)]

def move(v):
    data = []
    temp = v

    for i in range(visited[v]+1):
        data.append(temp)
        temp = node[temp]
    
    print(' '.join(map(str,data[::-1])))


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
                node[nextv] = v

print(BFS(N))
move(K)
