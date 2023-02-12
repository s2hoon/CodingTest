N , K = map(int, input().split())

dp =[ 0 for i in range(100000+2)]

dp[N] = 0
dp[N+1] = 1

for i in range(0,N):
    dp[i] = N-i


if N <=K:
    for i in range(N+2, K+1):
        dp[i] =dp[i-1] +1

        if i % 2 == 0:
            dp[i] = min(dp[i],dp[i//2]+1)
        else:
            dp[i] = min(dp[i],dp[(i+1)//2]+2,dp[(i-1)//2]+2)
        #print(i,dp[i])

print(dp[K])

