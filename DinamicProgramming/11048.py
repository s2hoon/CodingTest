N , M = map(int,input().split())

graph = []
for i in range(N):
    graph.append(list(map(int,input().split())))

# init
dp = [[ 0 for i in range(M)] for j in range(N)]
dp[0][0] = graph[0][0]
for i in range(1,M):
    dp[0][i] = dp[0][i-1]+ graph[0][i]

for i in range(1,N):
    dp[i][0] = dp[i-1][0] + graph[i][0]

# bottom up
for i in range(1,N):
    for j in range(1,M):
        dp[i][j] = max(dp[i][j-1] + graph[i][j], dp[i-1][j]+ graph[i][j], dp[i-1][j-1] + graph[i][j])

print(dp[-1][-1]) 


