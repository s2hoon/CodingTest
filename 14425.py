import sys
N, M = map(int,sys.stdin.readline().strip().split())

S = dict()
for i in range(N):
    S[sys.stdin.readline().strip()] = 1

cnt = 0
for j in range(M):
    try:
        if S[sys.stdin.readline().strip()] == 1:
            cnt +=1
    except:
        continue
print(cnt)
   