import sys
N = int(input())

W =[]
for i in range(N):
    W.append(list(map(int, input().split())))
visited = [False for i in range(N)]
min_value = sys.maxsize

def BackTrack(start, next,value , visited,cnt):
    global min_value
    if cnt == N:
        if W[next][start] !=0:
            min_value = min(min_value, value + W[next][start])
        return
    for i in range(N):
        if visited[i]==False and W[next][i]!=0:
            visited[i]=True
            BackTrack(start, i, value+W[next][i] ,visited,cnt +1)
            visited[i] =False


for i in range(N):
    visited[i] =True
    BackTrack(i,i,0,visited,1)
    visited[i]=False


print(min_value)