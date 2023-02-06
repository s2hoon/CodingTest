
from collections import deque


N , M, V= map(int,input().split())

graph_node= [[]for _ in range(N+1) ]
for i in range(M):
    a, b = map(int, input().split())
    graph_node[a].append(b)
    graph_node[b].append(a)

for item in graph_node:
    item.sort()

print(graph_node)

start = V
visited = [False] *(N+1)
bfs = []
dfs = []


def DFS(graph_node, start):
    visited[start] = True
    dfs.append(start)
    for i in graph_node[start]:
        if(visited[i]==False):
            DFS(graph_node, i)


queue  = deque([start])
def BFS(graph_node, start):
    visited = [False] *(N+1)
    visited[start] = True
    while queue:
        node =queue.popleft()
        bfs.append(node)
        for n in graph_node[node]:
            if(visited[n] == False):
                queue.append(n)
                visited[n] = True

DFS(graph_node, start)
BFS(graph_node , start)

print(*dfs)
print(*bfs)



    













    



# visited = [False] * 4
# start = 1

#DFS(graph, 1, visited)
