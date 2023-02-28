import copy
N , M = map(int, input().split())
num = (list(map(int, input().split())))
num.append(0)
num.sort()
visited = [False for i in range(10000+1)] 
result = []
result2 = []
result3 = []
def DFS():
    if len(result) == M:
        print(' '.join(map(str,result)))
        return

    #overlap = 0
    for i in range(1,N+1):
         if visited[i] ==False :
            visited[i] =True
            result.append(num[i])
         
            DFS()
            result.pop()
            visited[i] =False


DFS()

