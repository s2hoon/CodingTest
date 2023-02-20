from collections import deque
M, N, H = map(int,input().split())
graph = [[list(map(int,input().split())) for i in range(N)] for j in range(H)]
#print(graph)
dx = [0,0,1,-1,0,0]
dy = [1,-1,0,0,0,0]
dz = [0,0,0,0,1,-1]
check =True
result = 0
queue = deque()

def BFS(graph): # 1단계 BFS

    while(queue):
        z,x,y = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if nx >=N or nx < 0 or ny >= M or ny < 0 or nz >= H or nz <0:
                continue

            if graph[nz][nx][ny] == 0:
                graph[nz][nx][ny] = graph[z][x][y] +1
                queue.append((nz,nx,ny))


for h in range(H): #층수
    for i in range(N): #세로
        for j in range(M): #가로
            if graph[h][i][j] ==1:
                queue.append((h,i,j))

BFS(graph) #BFS 1단계

    
for h in range(H): #층수
    for i in range(N): #세로
        for j in range(M): #가로
            if graph[h][i][j] == 0:
                check =False
                
            result = max(result,graph[h][i][j])
            
if check ==False:
    print(-1)
else:
    print(result-1)