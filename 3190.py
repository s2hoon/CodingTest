import sys

N = int(sys.stdin.readline().strip())
K = int(sys.stdin.readline().strip())
graph = [[0 for i in range(N)] for j in range(N)]
apple = [[False for i in range(N)]for j in range(N)]
for i in range(K):
    x,y = map(int,sys.stdin.readline().strip().split())
    apple[x-1][y-1] = True

L  = int(sys.stdin.readline().strip())

d = []
for i in range(L):
    d.append(list(sys.stdin.readline().strip().split()))
time = 0
x ,y = 0,0
direction = 0 # 초기 방향 오른쪽
graph[x][y] = 1 # 시작
dx = [0,1,0,-1]
dy = [1,0,-1,0]
queue = []
queue.append((0,0))

while(1):
    time += 1
    nx = x + dx[direction]
    ny = y + dy[direction]

    if nx >= N or ny >= N or nx < 0 or ny < 0:
        print(time)
        exit()
            
    if graph[nx][ny] == 1:
        print(time)
        exit()
            
    if apple[nx][ny] == True:
        graph[nx][ny] = 1
        apple[nx][ny] = False
        queue.append((nx,ny))
    else:
        (tx,ty)=queue.pop(0)
        graph[tx][ty] = 0
        graph[nx][ny] = 1
        queue.append((nx,ny))

    if d:
        if time == int(d[0][0]):
            if d[0][1] == 'D':
                direction = (direction+1) %4
            elif d[0][1]=='L':
                direction = (direction-1)%4
            d.pop(0)


    x, y = nx, ny
          
        


    
    

