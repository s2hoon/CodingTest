from collections import deque

dy = [1, 1, 1, 0, 0, -1, -1, -1]
dx = [-1, 0, 1, -1, 1, -1, 0, 1]

def BFS(x,y, graph):

        queue = deque()
        queue.append((x,y))
        graph[x][y] = 0

        while(queue):
            x, y =queue.popleft()
            for i in range(8):
                nx = x +dy[i]
                ny = y +dx[i]
    
                
                if nx >= h or nx < 0 or ny >= w or ny <0:
                    continue
                elif graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    queue.append((nx,ny))
                

while(1):
    w, h = map(int, input().split())
    if w ==0 and h ==0:
        break
    graph = []

    for i in range(h):
        graph.append(list(map(int,input().split())))


    count =0
    for i in range(h):
        for j in range(w):

            if graph[i][j] == 1:
                BFS(i,j , graph)
                count +=1

               
    print(count)




    
