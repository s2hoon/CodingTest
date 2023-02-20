from collections import deque

N = int(input())
graph = []
dx = [0,0,1,-1]
dy = [1,-1,0,0]
visited = [[False for i in range(N)] for i in range(N)]
for i in range(N):
    graph.append(list(map(int, input())))
count = 0
hs_count =[]



def BFS(a,b , graph, visited):
    temp_count =1 
    visited[a][b]=True

    queue =deque()
    queue.append((a,b))

    while(queue):
        x, y=queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            

            if nx >=N or nx <0 or ny >= N or ny < 0:
                continue
            
            if visited[nx][ny] ==False and graph[nx][ny] == 1:
                temp_count +=1
                graph[nx][ny] = 0
                visited[nx][ny]= True
                queue.append((nx,ny))
    hs_count.append(temp_count)


for i in range(N):
    for j in range(N):
        if visited[i][j] == False and graph[i][j] != 0:
            count +=1
            BFS(i,j,graph,visited)
#print(graph)
print(count)
hs_count.sort()
for i in hs_count:
    print(i)
