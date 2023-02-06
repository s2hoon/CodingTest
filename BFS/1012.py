from collections import deque
dx = [1,-1,0,0]
dy = [0,0,-1,1]

def BFS(a,b, graph):
    queue = deque()
    queue.append((a,b))
    graph[a][b] = 0

    while(queue):
        x,y =queue.popleft()
        for i in range(4):
            nx = x+ dx[i]
            ny = y +dy[i]
            if nx >= M or nx < 0 or ny >=N or ny <0:
                continue
        
            if graph[nx][ny]==1:
                queue.append((nx, ny))
                graph[nx][ny] = 0

T = int(input())
for i in range(T):
    M, N, K = map(int, input().split())
    graph = [[ 0 for i in range(N)] for j in range(M)]
    
    for j in range(K):
        a, b = map(int, input().split())
        graph[a][b] = 1
    

    count = 0
    for i in range(M):
        for j in range(N):
            if graph[i][j] == 1:
                BFS(i,j,graph)
                count+=1

    print(count)



