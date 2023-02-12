N , M = map(int, input().split())

graph = []

for i in range(N):
    graph.append(list(map(int, input().split())))

visited =[[False for i in range(M)] for i in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
dx2 = [1,-1]
dy2 = [0,0]
dx3 = [0,0]
dy3 = [1,-1]
result = []
result_arr =[]
def others(x,y,graph):

    #남북탐색
    for j in range(2):
        nx =x +dx[j]
        ny =y +dy[j]
        if nx >=N or nx < 0 or ny >=M or ny <0:
                continue
        else:
   
            for i in range(2):
                nx = nx + dx2[i]  
                ny = ny + dy2[i]

                if (nx+1) >=N or (nx-1) < 0 or ny >=M or ny <0:
                    continue
                else:
                    result.append(graph[nx][ny])
                    result.append(graph[nx+1][ny])
                    result.append(graph[nx-1][ny])
                    result_arr.append(sum(result))
                    result.pop()
                    result.pop()
                    result.pop()

    #동서탐색         
    for j in range(2,4):
        nx =x +dx[j]
        ny =y +dy[j]
        if nx >=N or nx < 0 or ny >=M or ny <0:
                continue
        else:
            for i in range(2):
                nx = nx + dx3[i]  
                ny = ny + dy3[i]
            
                if nx >=N or nx < 0 or (ny+1) >=M or (ny-1) <0:
                    continue
                else:
                    result.append(graph[nx][ny])
                    result.append(graph[nx][ny+1])
                    result.append(graph[nx][ny-1])
                    result_arr.append(sum(result))
                    result.pop()
                    result.pop()
                    result.pop()
          



def DFS_backtrack(x,y,graph):
    global result
    global result_arr
    if len(result) == 4:
        suming = sum(result)
        result_arr.append(suming)
        #print(result)
        return

    
    for i in range(4):
        nx = x +dx[i]
        ny = y +dy[i]
        if nx >=N or nx < 0 or ny >=M or ny <0:
            continue
        else:
            if visited[nx][ny] ==False:
                visited[nx][ny] =True
                result.append(graph[nx][ny])
                DFS_backtrack(nx,ny,graph)
                result.pop()
                visited[nx][ny] =False
            
     

for i in range(N):
    for j in range(M):
        visited[i][j] =True
        result.append(graph[i][j])
        DFS_backtrack(i,j,graph)
        result.pop()
        visited[i][j] =False



for i in range(N):
    for j in range(M):
        result.append(graph[i][j])
        others(i,j,graph)
        result.pop()



print(max(result_arr))