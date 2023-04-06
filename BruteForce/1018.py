N , M=  map(int,input().split())

graph = []
result = []
for i in range(N):
    graph.append(input())


for i in range(N - 7):
    for j in range(M - 7 ):
        count1 = 0 # B로 시작할때
        count2 = 0 # W로 시작할때
        for k in range(i, i + 8):
            for t in range(j , j +8):
                if (k+ t) %2 ==0:
                    if graph[k][t]=="W":
                        count1 +=1
                    if graph[k][t]=="B":
                        count2 +=1
                else:
                    if graph[k][t] =="B":
                        count1 +=1
                    if graph[k][t] =="W":
                        count2+=1
        result.append(min(count1, count2))



print(min(result))







print(graph)



print(N,M)