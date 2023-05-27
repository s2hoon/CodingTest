N = int(input())

stair = []
stair.append(0)
for i in range(N):
    stair.append(int(input()))


dp = [0 for i in range(301)]
dp[0] = 0
dp[1] = stair[1]
dp[2] = stair[1] + stair[2]
dp[3] = max(stair[2] + stair[3] , stair[1] + stair[3])
#dp[4] = max(dp[1] + stair[3] + stair[4] ,dp[2] + stair[4])


for i in range(4, N+1):
    dp[i] = max(dp[i-3] + stair[i-1]+stair[i] , dp[i-2] + stair[i] )

print(dp[N])
    