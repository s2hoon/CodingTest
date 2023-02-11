#print(' '.join(map(str,s))) -> map 형변환
import copy
N , M = map(int,input().split())
result = []
visited = [False for i in range(N+1)]
check = 1
def BackTrack(check):
    if len(result) == M:
        for i in range(M-1):
            if result[i] > result[i+1]:
                check = 0
                break
            else:
                check =1
        
        if check ==1:
            print(' '.join(map(str,result)))
            


    for i in range(1,N+1):
        if visited[i] ==False :
            visited[i] =True
            result.append(i)
            BackTrack(check)
            result.pop()
            visited[i] =False

BackTrack(check)