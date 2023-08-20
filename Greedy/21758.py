N = int(input())

num = list(map(int, input().split()))

dp = [ 0 for i in range(N)]
dp[0] = num[0]
for i in range(1, N):
    dp[i] = dp[i-1]+ num[i]

print(dp)
result = 0
# 벌통이 왼쪽
for i in range(1,N-1): 
    result=max(result,dp[N-2]+dp[i-1]-num[i])


# 벌통이 오른쪽
for i in range(1, N-1): 
    result = max(result, dp[N-1] - num[0] - num[i] + dp[N-1] - dp[i]) 

   
# 벌통이 중간에
for i in range(1,N-1): 
    result=max(result,dp[N-2] - num[0] + num[i])

print(result)