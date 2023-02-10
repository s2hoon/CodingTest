import sys
import copy
sys.setrecursionlimit(10**6)
N = int(input())
graph = []

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def DFS(x,y , rain,visited):
    visited[x][y] =True
    rain[x][y] = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= N or nx < 0  or ny >= N or ny <0:
            continue
        if rain[nx][ny] != 0:
            DFS(nx, ny, rain, visited)
 

for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

#print(graph)

graph_max = 1
for i in range(N):
    for j in range(N):
        graph_max = max(graph[i][j],graph_max)



max_count =0 
for k in range(1, graph_max+1):

    rain = copy.deepcopy(graph)
    visited = [[False for i in range(N)]for j in range(N)]

    for i in range(N):
        for j in range(N):
            if graph[i][j] <= k:
                rain[i][j] = 0
    
    #print(graph)

    count =0
    for i in range(N):
        for j in range(N):
            if rain[i][j] !=0 and visited[i][j]==False:
                count += 1
                DFS(i,j,rain,visited)
                max_count = max(count, max_count)

if max_count ==0:
    print(max_count+1)
else:
    print(max_count)

