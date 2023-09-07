import sys
from itertools import permutations
from itertools import combinations
N = int(sys.stdin.readline().strip())
person = [ i for i in range(1,N+1)]
graph = []
result = 1e9

for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))
    
for comb in combinations(person, N//2):
    S = 0
    comb = list(comb)
    for t in combinations(comb,2):
        (a, b) = t
        S += graph[a-1][b-1] 
        S += graph[b-1][a-1]
    #나머지 temp 에 추가
    temp = []
    for item in person:
        if item not in comb:
            temp.append(item)
    S2 = 0
    for t in combinations(temp,2):
        (a, b) = t
        S2 += graph[a-1][b-1] 
        S2 += graph[b-1][a-1]

    result = min(abs(S-S2),result)

print(result)





                 
