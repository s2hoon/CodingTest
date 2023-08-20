N = int(input())

P = list(map(int,input().split()))
P.sort()

dp = [0 for i in range(N)]
dp[0] = P[0]
for i in range(1, N):
    dp[i] += dp[i-1] + P[i]

print(sum(dp))