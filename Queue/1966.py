T = int(input())
for i in range(T):
    N, M = map(int,input().split())
    tmp = list(map(int,input().split()))
    queue = []
    for idx, item in enumerate(tmp):
        queue.append((item,idx))
        
    ans = []
    while(queue):
        (t,a)  = queue.pop(0) 
        if queue and t < max(queue,key=lambda x : x[0])[0]:
            queue.append((t,a))
        else:
            ans.append((t,a))
            continue
    
    for idx, item in enumerate(ans):
        if item[1] == M:
            print(idx+1)