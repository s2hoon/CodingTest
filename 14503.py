import sys

N , M = map(int,sys.stdin.readline().strip().split())
r, c , d = map(int,sys.stdin.readline().strip().split())
graph = []
for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))

dx = [-1,0,1,0]
dy = [0,1,0,-1]
ans = 0
def BackTrack(x,y,d):
    global ans
    if x >= N or y >= M or x<0 or y<0:
        return
 
    else:
        # 현재 칸이 아직 청소되지 않은 경우, 현재칸을 청소
        if graph[x][y] == 0:
            graph[x][y] = 2
            ans +=1

        check =False
        for i in range(4):
            nx = x + dx[(d-i)%4]
            ny = y + dy[(d-i)%4]
            if nx >= N or ny >= M or nx < 0 or ny < 0:
                continue
            if graph[nx][ny] == 0:
                check = True
                break
        #현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        if check == True:
            d = (d-1) % 4
            if graph[x + dx[d]][y + dy[d]] == 0:
                BackTrack(x + dx[d],y + dy[d],d)
            else:
                BackTrack(x,y,d)
        # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, 후진
        else:
            nx = x - dx[d]
            ny = y - dy[d]
            if graph[nx][ny] == 1:
                return
            else:
                BackTrack(nx,ny,d)
                    
     
BackTrack(r,c,d)
print(ans)