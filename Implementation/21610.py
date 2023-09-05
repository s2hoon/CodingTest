import sys
N, M = map(int,sys.stdin.readline().strip().split())
graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip().split())))
move = []
for i in range(M):
    d, s = map(int,sys.stdin.readline().strip().split())
    move.append([d,s])

dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]
# (N, 1), (N, 2), (N-1, 1), (N-1, 2) 얘네가 처음 구름
def rain(temp):
    for t in temp:
        [x, y] =t
        cnt = 0
        for i in range(1,len(move),2):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= N or ny >= N or nx < 0 or ny < 0:
                continue
            else:
                if graph[nx][ny] != 0:
                    cnt +=1
        graph[x][y] += cnt

def moving(windows,t):
    if t == len(move)-1:
        return
    temp = []
    for window in windows:
        x = (window[0] + dx[move[t][0]] * move[t][1]) % (N)
        y = (window[1] + dy[move[t][0]] * move[t][1]) % (N)
        temp.append([x,y])
        print(window, x,y, move)
        graph[x][y] +=1
    print(temp)
    rain(temp)
    
    # lst_t = []
    # for i in range(N):
    #     for j in range(N):
    #         if graph[i][j] >= 2:
    #             lst_t.append([i,j])
    
    # return moving(lst_t,t+1)



moving([[N, 1], [N, 2], [N-1, 1], [N-1, 2]], 0)


print(graph)