N, M = map(int,input().split())

result = []

def BackTrack():
    if len(result) ==M:
        print(' '.join(map(str,result)))
        return


    for i in range(1,N+1):
        result.append(i)
        BackTrack()
        result.pop()

BackTrack()