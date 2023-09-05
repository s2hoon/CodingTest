N,M = map(int,input().split())

nums = list(map(int,input().split()))

ans = 1e9
for i in range(N):
    for j in range(i+1, N):
        for t in range(j+1, N):
            s = nums[i] + nums[j] + nums[t]
            if M -s >= 0:
                if ans >= M-s:
                    ans = M-s
                    a, b, c = nums[i],nums[j],nums[t]
                
print(sum([a,b,c]))
