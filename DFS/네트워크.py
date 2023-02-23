def solution(n, computers):
    answer = 0
    visited = [False for i in range(n)]
    for i in range(n):
        if visited[i] == False:
            answer+=1
            DFS(i, visited, computers, n)
        
    return answer


def DFS(start, visited, graph,n):
    visited[start] =True
    for idx , item in enumerate(graph[start]):
            if item != 0 and visited[idx] ==False:
                visited[idx]=True
                DFS(idx,visited,graph,n)