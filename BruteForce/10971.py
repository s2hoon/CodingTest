N = int(input())

W =[]
for i in range(N):
    W.append(list(map(int, input().split())))

temp = []
result = []
visited = [[False for i in range(N)] for i in range(N)]

print(W)

def BackTrack(start,W):

    if len(temp) == N:
        print()
        return

    for i in range(N): #10
        for j in range(N): #10
            if visited[i][j] ==False:

