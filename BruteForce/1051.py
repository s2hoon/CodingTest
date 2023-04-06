N , M =input().split()
N = int(N)
M = int(M)

minnum = min(M, N)

graph = []
for i in range(N):
    graph.append(list(map(int, input())))
result = [] 

for i in range(N):
    for j in range(M):
        for k in range(minnum):
            check = False

            if i+k >= N or j+k>= M:
                continue

            if graph[i][j] == graph[i+k][j] and graph[i][j]==graph[i][j+k] and graph[i][j] == graph[i+k][j+k]:
                check = True

            if check == True:
                result.append(k)


resulting = int(max(result))
resulting = resulting +1
print(resulting**2)