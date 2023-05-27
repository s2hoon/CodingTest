T = int(input())
for i in range(T):
    N = int(input())
    dp = [(0,0) for i in range(41)]
    dp[0] = (1 , 0)
    dp[1] = (0 , 1)
    dp[2] = (1 , 1) 
    dp[3] = (1 , 2)
    for i in range(4, 41):
        a, b= dp[i]
        num1, num2 = dp[i-2]
        num3, num4 = dp[i-1]
        a = num1 + num3
        b = num2 + num4 
        dp[i] = (a,b)
    
    print(' '.join(map(str, list(dp[N]))))


# for i in range(T):
#     N = int(input())









