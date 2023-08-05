N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))


def reculsive(N):
    N = N //3
    temp = []

    for i in range(N):
        for j in range(N):
            temp.append(graph[i][j])
            print(graph[i][j])

reculsive(N)
  
