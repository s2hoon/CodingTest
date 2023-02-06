from collections import deque

def BFS(graph):
    visited = [False] * 9 
    start =1 

    queue = deque([start])
    visited[start] = True

  


    while queue:
        node = queue.popleft()
        print(node, end ='제거 ') 
        for nearnode in graph[node]:
            if visited[nearnode]==False:
                queue.append(nearnode)
                visited[nearnode] =True








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


BFS(graph )














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
