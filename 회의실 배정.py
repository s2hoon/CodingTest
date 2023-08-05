import sys
N = int(sys.stdin.readline())

study = []

for i in range(N):
    study.append(list(map(int,sys.stdin.readline().split())))

study.sort(key = lambda x:  (x[1],x[0]))


#print(study)

answer = []
answer.append(study[0])

for item in study[1:]:
    if item[0] >= answer[-1][1]:
        answer.append(item)

print(len(answer))
