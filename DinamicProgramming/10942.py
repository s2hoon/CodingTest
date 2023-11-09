import sys
sys.setrecursionlimit(100000)
N = int(sys.stdin.readline().strip())
arr = list(map(int,sys.stdin.readline().strip().split()))
arr.insert(0,0)
M = int(sys.stdin.readline().strip())
dp =[ [-1 for i in range(N+1)] for j in range(N+1)]

def go(i, j):
    if i == j:
        return 1
    elif i+1 == j:
        if arr[i] == arr[j]:
            return 1
        else:
            return 0

    if dp[i][j] != -1:
        return dp[i][j]
    if arr[i] != arr[j]:
        dp[i][j] = 0        
    else:
        dp[i][j] = go(i+1,j-1)
    return dp[i][j]

for i in range(M):
    a, b = map(int,sys.stdin.readline().strip().split())
    print(go(a,b))