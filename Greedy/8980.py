import sys
from collections import defaultdict
import heapq
N, C = map(int, sys.stdin.readline().strip().split())
M = int(sys.stdin.readline().strip())
boxs = []
for i in range(M):
    boxs.append(list(map(int,sys.stdin.readline().strip().split())))

for i in range(1,N+1):
    boxs.append([i,i,0])
boxs.sort(key= lambda x : (x[1],x[0]))
print(boxs)

ans = 0
dic = {}
for i in range(1,N+1):
    dic[i] = 0
print(dic)
hq = []


for box in boxs:
    print(box, "해당백스")
    if dic[box[0]]!=0:
        C += dic[box[0]]
        print(dic[box[0]],"박스 배송완료")
        ans += dic[box[0]]
        dic[box[0]] = 0
        print(ans, "총 배달완료수")


    print(C, "남은 제한")
    if C > box[2]:    
        dic[box[1]] += box[2]
        print(box[2],"박스 싣기")
        C -= box[2]
    elif C == box[2]:
        dic[box[1]] += box[2]
        print(box[2], "박스 싣기")
        C -= box[2]

    elif C < box[2] :
        dic[box[1]] += C
        print(C, "박스 싣기")
        C -= C
     
print(dic)
print(ans+dic[N])


