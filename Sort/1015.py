N = int(input())

A = list(map(int, input().split()))

#p 는 A 의 순서가 들어가야함
A.sort()
idx = -1
for i in A:
    idx +=1
    print(idx)