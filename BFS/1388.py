from collections import deque


dx = [1,-1,0,0]
dy = [0,0,-1,1]


def BFS(x,y,graph):
    queue =deque()
    queue.append((x,y))

    while(queue):
        x, y  = queue.popleft()
        if graph[x][y]=='-' :    
            graph[x][y]=0
            for i in range(2,4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if nx >= N or nx < 0 or ny >=M or ny <0:
                    continue

                elif( graph[nx][ny] == '-'):
                    queue.append((nx,ny))
        if graph[x][y]=='|' :    
            graph[x][y]=0
            for i in range(0,2):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if nx >= N or nx < 0 or ny >=M or ny <0:
                    continue

                elif( graph[nx][ny] == '|'):
                    queue.append((nx,ny))
             
                







N , M = map(int, input().split())

graph= []
count = 0
for i in range(N):
    graph.append(list(input()))



for i in range(N):
    for j in range(M):
            if graph[i][j]!=0:
                BFS(i,j,graph)
                count+=1


print(count)