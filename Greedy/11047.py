import sys

N, K = map(int, sys.stdin.readline().strip().split())
A = []
for i in range(N):
    A.append(int(sys.stdin.readline().strip()))

cnt = 0
ptr = len(A) -1
while(K != 0):
    if K // A[ptr] != 0:
        cnt += K //A[ptr]
        K = K % A[ptr]
    ptr -=1

print(cnt)
  