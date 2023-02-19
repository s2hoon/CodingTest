from collections import deque
N = int(input())

graph = [[]for i in range(N+1)] # 0은 없음
visited = [0 for i in range(N+1)]


for i in range(N-1):
    a , b =map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

answer = list(map(int,input().split()))
#print(graph)
#print(answer)




def BFS(start,graph, visited):
    visited[start] = -1

    queue = deque()
    queue.append(start)

    depth = 0
    while(queue):
        vertex = queue.popleft()
        depth +=1
        for i in graph[vertex]:
            if  visited[i] ==0:
                queue.append(i)
                visited[i]=depth
                #print(i, depth)

    
BFS(answer[0], graph, visited)
visited[1] =0

check =1
for i in range(N-1):
    if visited[answer[i]] > visited[answer[i+1]]:
        check = 0


print(check)