from collections import deque

def solution(maps):
    answer = 0
    count = 1
    n = len(maps)
    m = len(maps[0])

    BFS(0,0,maps,count,n,m)
    if maps[n-1][m-1] == 1:
        answer = -1
    else:
        answer = maps[n-1][m-1]
    
    
    return answer


def BFS(a,b,  graph, count,n,m):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    
    queue =deque()
    queue.append((a,b))
    while(queue):
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >=n or nx < 0 or ny >= m or ny<0:
                continue
            
            if graph[nx][ny] ==1:
                graph[nx][ny] += graph[x][y] 
                queue.append((nx,ny))

                
    
    