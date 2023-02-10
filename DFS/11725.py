import sys
sys.setrecursionlimit(1000000)
N = int(input())
graph = [[]for i in range(N+1)]
visited = [ False for i in range(N+1)]
parent = [0 for i in range(N+1)]

for i in range( N-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

def DFS(start, graph,visited,parent):
    visited[start] = True

    for i in graph[start]:
        if visited[i] ==False:
            parent[i] = start
            DFS(i, graph, visited,parent)


for i in range(1,N+1):
    if visited[i] ==False:
        DFS(i, graph,visited, parent)

for i in range(2, N+1):
    print(parent[i])
