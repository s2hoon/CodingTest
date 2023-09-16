import sys

N,M ,x,y, K = map(int, sys.stdin.readline().strip().split())

graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip().split())))

commands = list(map(int,sys.stdin.readline().strip().split()))

dx = [0,0,0,-1,1]
dy = [0,1,-1,0,0]
row = [0,0,0,0] #가로
col = [0,0,0,0] #세로
for command in commands:
    nx = x + dx[command]
    ny = y + dy[command]

    if nx >= N or ny >=M or nx< 0 or ny < 0:
        continue
    x = x + dx[command]
    y = y + dy[command]

  
    #동쪽
    if command == 1:
        temp = row[3]
        row[3] = row[2]
        row[2] = row[1]
        row[1] = row[0]
        row[0] = temp
        col[1] = row[1]
        col[3] = row[3]
    #서쪽
    elif command == 2:
        temp = row[0]
        row[0] = row[1]
        row[1] = row[2]
        row[2] = row[3]
        row[3] = temp
        col[1] = row[1]
        col[3] = row[3]
    #북쪽
    elif command == 3:
        temp = col[0]
        col[0] = col[1]
        col[1] = col[2]
        col[2] = col[3]
        col[3] = temp
        row[1] = col[1]
        row[3] = col[3]
    #남쪽
    elif command == 4:
        temp = col[3]
        col[3] = col[2]
        col[2] = col[1]
        col[1] = col[0]
        col[0] = temp
        row[1] = col[1]
        row[3] = col[3]

    if graph[x][y] == 0:
        graph[x][y]=col[3]
        
    else:
        col[3] = graph[x][y] 
        row[3] = graph[x][y]
        graph[x][y] = 0
    
   
    print(col[1])



        

