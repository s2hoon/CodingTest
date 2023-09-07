import sys
N = int(sys.stdin.readline().strip())
graph = [[ 0 for i in range(N)] for j in range(N)]
visited = [[False for i in range(N)] for j in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
# (1)비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
def rule1(adje):
    count = [[0 for i in range(N)] for j in range(N)]
    max_cnt = 0
    for x in range(N):
        for y in range(N):
            if visited[x][y] == False:
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if nx >= N or ny >= N or nx < 0 or ny < 0:
                        continue
                    else:
                        if graph[nx][ny] in adje:
                            count[x][y] += 1
                            max_cnt = max(max_cnt, count[x][y])
    temp =[]
    for x in range(N):
        for y in range(N):
            if count[x][y] >= max_cnt:
                temp.append([x,y])
    return temp
    
                                       
# (2)1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
# (3)2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 
# (4)그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
def rule2(temp):
    count = [[0 for i in range(N)] for j in range(N)]
    max_cnt = 0
    for i in range(len(temp)):
        [x,y] = temp[i]
     
        for j in range(4):
            nx = x + dx[j]
            ny = y + dy[j]
            if nx >= N or ny >= N or nx < 0 or ny <0:
                continue
            else:
                if graph[nx][ny] == 0:
                    count[x][y] +=1
                    max_cnt = max(max_cnt, count[x][y])
    
    print(count)
    for x in range(N):
        for y in range(N):
            if visited[x][y] == False:
                if count[x][y] >= max_cnt:
                    return (x,y)
            
for i in range(N*N):
    a,b,c,d,e = map(int, sys.stdin.readline().strip().split())
    temp =rule1([b,c,d,e])
    (x,y) = rule2(temp)
    graph[x][y] = a 
    visited[x][y] =True
    print(graph) 



# 20 * 20 * 400


