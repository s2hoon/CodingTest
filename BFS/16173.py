from collections import deque

N= int(input())

graph = []
visited = [[False for i in range(N)] for j in range(N)]

for i in range(N):
    graph.append( list(map(int,input().split())))
   

dx = [0,0,1,-1]
dy = [1,-1,0,0]


def BFS(graph,x,y,visited):
    queue =deque()
    queue.append((x,y))
    

    while(queue):
        x, y =queue.popleft()
    
      
        for i in range(4):
            nx = x + dx[i]* graph[x][y]
            ny = y + dy[i]* graph[x][y]
            #print(nx, ny)

            if nx >= N or ny>= N or nx <0 or ny < 0:
                continue
            elif nx == N-1 and ny ==N-1:
                print("HaruHaru")
                return
            else:
                if visited[nx][ny]== False:
                    queue.append((nx,ny))
                    visited[nx][ny]=True
                
    print("Hing")

BFS(graph,0,0,visited)