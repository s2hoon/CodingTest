#1. 아이디어 : 
#2. 시간복잡도
#3. 자료구조 : stack DFS


def DFS(start, graph,visited):
    visited[start] = True
    
    for item in graph[start]:
        if not visited[item]:
            DFS(item, graph,visited)



N = int(input())
M = int(input())
graph = [[i ] for i in range(N+1)]
visited = [ False for i in range(N+1)]

for i in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[a].sort()
    graph[b].append(a)
    graph[b].sort()


DFS(1,graph,visited)

count = 0 
def counting(count):
    for i in visited:
        if i ==True:
            count +=1
        
    return count -1


print(counting(count))