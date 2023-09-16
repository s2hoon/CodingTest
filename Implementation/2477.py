K = int(input())

graph = []
for i in range(6):
    graph.append(list(map(int,input().split())))

total = 0
for i in range(len(graph)):
    if graph[i][0] == graph[(i+2)%6][0] and graph[(i+1)%6][0] == graph[(i+3)%6][0]:
        total = total - graph[(i+2)%6][1] * graph[(i+1)%6][1]
        a, b = graph[i][0] , graph[(i+1)%6][0]


temp = 1
for item in graph:
    if item[0] != a and item[0]!=b:
        temp *= item[1]

total += temp
print(total*K)

        

