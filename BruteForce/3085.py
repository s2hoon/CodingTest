#2중 for 사용

# for i in range(N):
#     for j in range(N):
#         graph[j][i] == graph[j+1][i] #열 고정


from collections import deque

N = int(input())

dx = [0,1]
dy = [1,0]

graph = []
for i in range(N):
    graph.append(list(input()))

#rint(graph)



def width():
    result = 0

    for i in range(N):
        temp_max =1
        for j in range(N-1):
            if graph[i][j] == graph[i][j+1]:
                temp_max += 1
                result = max(temp_max, result)
            else:
                temp_max = 1

    return result

def height():
    result = 0
    
    for i in range(N ):   #N-1행까지
        temp_max =1
        for j in range(N-1 ): #
            if graph[j][i] == graph[j+1][i]:
                #print(i , j)
                temp_max += 1
                result = max(temp_max, result)
        
            else:
                temp_max = 1

    return result



start_result = max(width(), height())
last_result = 0
for x in range(N):
    for y in range(N):
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= N or nx < 0 or ny >= N or ny < 0:
                continue
            if graph[nx][ny] != graph[x][y]:
                #
                graph[nx][ny],graph[x][y] = graph[x][y] ,graph[nx][ny]
                #count
                last_result = max(width(), height(), start_result,last_result)
                graph[nx][ny],graph[x][y] = graph[x][y] ,graph[nx][ny]
        
         

print(last_result)



            

