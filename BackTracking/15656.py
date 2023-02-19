N , M = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
visited = [False for i in range(10000+1)]
result = []
#print(num)
def DFS():
    if len(result) == M:
        print(' '.join(map(str,result)))
        return

    for i in num:
        result.append(i)
        DFS()
        result.pop()


DFS()

