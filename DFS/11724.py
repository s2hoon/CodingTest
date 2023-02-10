#sys.setrecursionlimit(5000) 런타임에러 오류수정.. 재귀함수 제한을 크게 잡아야함 디폴트는 1000

import sys
sys.setrecursionlimit(2000)
N , M = map(int, input().split())
graph = [[]for i in range(N+1)]
visited = [ False for i in range(N+1)]


for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a) 
    graph[a].sort()
    graph[b].sort()
#print(graph)   



def DFS(start , graph,visited):
    visited[start] =True

    for i in graph[start]:
        if visited[i] ==False:
            DFS(i, graph,visited)

    
count =0 
for i in range(1,N+1):
    if visited[i] ==False:
        count +=1
        DFS(i, graph,visited)

#print(visited)
print(count)

