n = int(input())

dp = [0 for i in range(n+1)]

dp[0] = 1
dp[1] = 1
# dp[2] = 3
# dp[3] = 5
# dp[4] = 11

for i in range(2, n+1):
    dp[i] = dp[i-2]*2 + dp[i-1]

print(dp[n]%10007)