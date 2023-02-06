N = int(input())
dfs = []

graph = [[] for _ in range(N+1)]
for i in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

answer = list(map(int, input().split()))

# for item in graph:
#     item.sort()
# 여기서 문제가 되는듯함 
# 문제 푸는 입장에서는 정렬을 안하고 문제를 풀수도있음
# 따라서 모든 순서를 고려해야하는데
# 결국에는 answer를 토대로 검증을해야함



print(graph)
visited = [False] * (N+1)
start = 1




def DFS(graph, start, visited):
    visited[start] = True
    dfs.append(start)
    for i in graph[start]:
        if (visited[i]==False):
            DFS(graph, i, visited)


DFS(graph, start, visited)

# print(answer)
# print(dfs)

if(answer==dfs):
    print(1)
else:
    print(0)