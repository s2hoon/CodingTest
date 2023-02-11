N, M = map(int,input().split())
num = list(map(int, input().split()))
setnum = set(num)
num2 = list(setnum)
num2.sort()
N = len(num2)
result = []
visited = [False for i in range(N)]


def BackTrack():

    if len(result) ==M:
        print(' '.join(map(str,result)))
        return

    for i in range(N):
        if visited[i] ==False:
            visited[i] =True
            result.append(num2[i])
            BackTrack()
            result.pop()
            visited[i] =False



BackTrack()