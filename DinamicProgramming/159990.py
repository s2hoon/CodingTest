import sys

T = int(sys.stdin.readline())


dp = [[0 for i in range(3)]for j in range(1, 100002)]
dp[1] = [1,0,0]
dp[2] = [0,1,0]
dp[3] = [1,1,1]
#print(dp)
for i in range(4,100001):
    #print(i)
    dp[i][0] = (dp[i-1][2] +dp[i-1][1])%1000000009
    dp[i][1] = (dp[i-2][0] +dp[i-2][2])%1000000009
    dp[i][2] = (dp[i-3][1] +dp[i-3][0])%1000000009
    

for i in range(T):
    n = int(sys.stdin.readline())
    print(sum(dp[n])%1000000009)