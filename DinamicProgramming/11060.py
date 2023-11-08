N = int(input())

arr = list(map(int,input().split()))

if N==1:
    print(0)
    exit()
dp = [1e9 for i in range(N)]
dp[0] = 0
for i in range(1,N):
    for j in range(i):
        if j+ arr[j] >= i:
            dp[i] = min(dp[j]+1,dp[i])


if dp[-1] == 1e9:
    print(-1)
else:
    print(dp[-1])