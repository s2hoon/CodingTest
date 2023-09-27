from itertools import combinations
n = 4
graph = [(x,y) for x in range(1, n+1) for y in range(1,n+1)]
answer = 0

for comb in combinations(graph,4):
    comb_list = list(comb)
    comb_list.sort(key =lambda x :x[0])

    x1, y1 = comb_list[0]
    x2, y2 = comb_list[1]
    x3, y3 = comb_list[2]
    x4, y4 = comb_list[3]
    

    #4변길이 확인 식
    if (x1- x2)**2 + (y1-y2)**2 == (x1-x3)**2 + (y1-y3)**2 == (x2-x4)**2 +(y2-y4)**2 == (x3-x4)**2 + (y3-y4)**2:
        if (x1 -x4) ** 2 + (y1 - y4)**2 == (x2-x3)**2 + (y2 - y3)**2:
            answer+=1
    

print(answer)