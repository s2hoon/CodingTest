N = int(input())

W =[]
for i in range(N):
    W.append(list(map(int, input().split())))

temp = []
result = []
visited = [False for i in range(N)]

print(W)

def BackTrack(start,next):

    if len(temp) == N:
        print()
        return

    for i in range(N): #10
        if visited[i]==False and W[start][next]!=0:
            visited[i]=True
            temp.append(W[start][i])
            BackTrack(start, next)


