import sys

N = int(sys.stdin.readline().strip())
graph = []
for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))


dp = [[ -1 for i in range(N)] for j in range(N)]
if graph[0][0] == 0:
    dp[0][0] = 1
else:
    dp[0][0] = 0


for i in range(1,N):
    if (graph[0][i]== (graph[0][i-1] +1)%3):
        dp[0][i] = dp[0][i-1] +1
    else:
        dp[0][i] = dp[0][i-1]

for i in range(1,N):
    if (graph[i][0] == (graph[i-1][0]+1)%3) :
        dp[i][0] = dp[i-1][0] +1
    else:
        dp[i][0] = dp[i-1][0]


cur_milk =graph[1][1]
for i in range(1,N):
    for j in range(1, N):
        if (graph[i][j]== (cur_milk +1)%3):
            dp[i][j] = max(dp[i][j] ,dp[i-1][j] +1)
            cur_milk = graph[i][j] 
            
        if (graph[i][j] == (cur_milk+1)%3):
            dp[i][j] = max(dp[i][j] ,dp[i][j-1] +1)
            cur_milk = graph[i][j] 
            
        if dp[i][j] == -1:           
            dp[i][j] = max(dp[i-1][j] , dp[i][j-1])

    
print(dp)
if dp[N-1][N-1] == -1 and graph[N-1][N-1] == 0:
    print(1)
elif dp[N-1][N-1] == -1:
    print(0)
else:
    print(dp[N-1][N-1])