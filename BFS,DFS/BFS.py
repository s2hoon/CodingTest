from collections import deque


def BFS(graph, start, visited):
    queue = deque([start]) #시작 1노드 큐에 추가
    visited[start] =True #1노드 방문완료

    while queue: #큐가 없어질때까지
        node = queue.popleft() #큐에서 방문한 노드를 뺌
        print(node, end ='제거 ') 



        #인접한 노드들(방문하지 않았다면) 큐에 추가
        for nearnode in graph[node]: #인접한 노드들 그래프안에 있는 모든 노드들 반복
            if not visited[nearnode]: #방문하지 않았다면
                queue.append(nearnode) #큐에 추가
                print(nearnode ,end ='인접노드큐에추가 ')
                visited[nearnode] = True #방문완료





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


BFS(graph , 1,visited)