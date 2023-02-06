def dfs(graph, v , visited):
    visited[v] = True
    print(v, end= " ")

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i , visited)




visited = [False] * 9 


graph = [
    [],
    [2,3,8], # 1시작 노드
    [1,7], #2노드
    [1,4,5], #3노드
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
dfs(graph, 1, visited)