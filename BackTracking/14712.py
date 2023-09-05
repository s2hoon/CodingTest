N , M = map(int,input().split())


graph = [[ 0 for i in range(N)] for j in range(M)]
visited = [[ False for i in range(N)] for j in range(M)]
result = []
ans = 0
dx = [0,0,1,-1]
dy = [1,-1,0,0]


def check():
    (x,y) =result[-1]
    print(x,y)
    if x -1 >= 0 and y-1 >=0:
        if graph[x][y-1] == 1 or graph[x-1][y] == 1 or graph[x-1][y-1] == 1:
            return 1
    return 0
def BackTrack():
    global ans
 
    # 4개짜리가 있다면 종료
    if len(result)>=4:
        if check():
            return
        
    # 나머지는 정답에 추가
    if len(result)>=1:
        ans+=1

    # 백트래킹 로직
    for i in range(N):
        for j in range(M):
            if visited[i][j] == False and graph[i][j] == 0:
                #print(i,j)
                result.append((i,j))
                visited[i][j] = True
                graph[i][j] = 1
                BackTrack()
                graph[i][j] = 0
                visited[i][j] = False
                result.pop()


BackTrack()
