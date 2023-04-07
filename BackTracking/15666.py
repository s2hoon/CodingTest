
N , M = map(int,input().split())

num = list(map(int, input().split()))
num = list(set(num))
num.sort()
N = len(num)



visited = [False for i in range(N)]
result = []

def back_track(x):
    if len(result) == M:
        print(' '.join(map(str, result)))
        return

    for i in range(x, N):
        result.append(num[i])
        back_track(i)
        result.pop()

back_track(0)






