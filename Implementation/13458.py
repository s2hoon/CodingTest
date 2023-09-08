import sys

N =  int(sys.stdin.readline().strip())
A = list(map(int, sys.stdin.readline().strip().split()))
B, C = map(int, sys.stdin.readline().strip().split())

cnt = 0
for item in A:

    if item <= B:
        cnt +=1
        continue

    item -= B
    cnt +=1
    
    if item % C != 0:
        cnt += item // C 
        cnt += 1
    else:
        cnt += item // C

print(cnt)