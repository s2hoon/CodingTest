from collections import deque
n = int(input())

a, b  = map(int, input().split())

m = int(input()) #edge 개수

graph = [[] for i in range(n+1)]
visited = [ -1 for i in range(n+1)]
for i in range(m):
    k, t = map(int,input().split())
    graph[k].append(t)
    graph[t].append(k)

print(graph)

def BFS(start, graph, visited):
    queue =deque()
    queue.append(start)
    visited[start]+=1
    while(queue):
        node =queue.popleft()
        for i in graph[node]:
            if visited[i] == -1:
                visited[i] =visited[node] +1
                queue.append(i)
    

BFS(a, graph, visited)                  
print(visited[b])
