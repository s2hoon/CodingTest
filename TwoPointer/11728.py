import sys
N , M = map(int, sys.stdin.readline().strip().split())
num = []
A = list(map(int, sys.stdin.readline().strip().split()))
B = list(map(int, sys.stdin.readline().strip().split()))

ptrA = 0
ptrB = 0
answer = []

while(ptrA < N and ptrB < M):
    if A[ptrA] <= B[ptrB]:
        answer.append(A[ptrA])
        ptrA +=1
    else:
        answer.append(B[ptrB])
        ptrB +=1

while(ptrA<N):
    answer.append(A[ptrA])
    ptrA +=1
while(ptrB<M):
    answer.append(B[ptrB])
    ptrB+=1


print(*answer)

