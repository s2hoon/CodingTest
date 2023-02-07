N = int(input())
dp = list(map(int, input().split()))
dp.insert(0,0)


for i in range( N+1):
    for j in range(1, i+1):
        dp[i] = min(dp[i] , dp[j] + dp[i-j])


print(dp[N])