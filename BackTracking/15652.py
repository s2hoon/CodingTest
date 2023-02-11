import copy
N, M = map(int,input().split())

result = []

def BackTrack(x):
        
    
    if len(result) ==M:
        print(' '.join(map(str,result)))
        #print(*result)
        return
 

    for i in range(x,N+1):
        result.append(i)
        BackTrack(i)
        result.pop()

BackTrack(1)