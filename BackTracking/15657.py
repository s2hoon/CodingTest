N , M = map(int, input().split())
num = list(map(int, input().split()))
num.append(0)
num.sort()
visited = [False for i in range(10000+1)]
result = []
#print(num)
def DFS(start):
    if len(result) == M:
        print(' '.join(map(str,result)))
        return

    for i in range(start,N+1):
        # if visited[i] ==False:
        #     visited[i] =True
            result.append(num[i])
            DFS(i)
            result.pop()
            # visited[i] =False


DFS(1)

