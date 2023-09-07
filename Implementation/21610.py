import sys
N, M = map(int,sys.stdin.readline().strip().split())
graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip().split())))
visited = [[False for i in range(N)] for j in range(N)]

move = []
for i in range(M):
    d, s = map(int,sys.stdin.readline().strip().split())
    move.append([d,s])
dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]
# (N, 1), (N, 2), (N-1, 1), (N-1, 2) 얘네가 처음 구름
def rain(temp):
    for t in temp:
        [x, y] = t
        cnt = 0
        for i in range(1,len(dx),2):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= N or ny >= N or nx < 0 or ny < 0:
                continue
            else:
                if graph[nx][ny] != 0:
                    cnt +=1
      
        graph[x][y] += cnt

def moving(windows,t):
    if t == len(move):
        return
    temp = []
    for window in windows:
        x = (window[0] + dx[move[t][0]-1] * move[t][1]) % N
        y = (window[1] + dy[move[t][0]-1] * move[t][1]) % N
        temp.append([x,y])
        visited[x][y] = True
        graph[x][y] +=1
    rain(temp)
    # 나머지 칸중에서 물의 양이 2이상인 칸에 구름이 생긴다. 구름이 생기면 물의 양이 2만큼 줄어든다
    tt = []
    for i in range(N):
        for j in range(N):
            if visited[i][j] == False and graph[i][j] >= 2:
                tt.append([i,j])
                graph[i][j] -= 2
            else:
                visited[i][j] = False
    moving(tt, t+1)


moving([[N-1, 0], [N-1, 1], [N-2, 0], [N-2, 1]], 0)

ans = 0
for i in range(N):
    for j in range(N):
        ans += graph[i][j]

print(ans)