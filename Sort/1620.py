import sys
N, M = map(int,sys.stdin.readline().strip().split())
dic = {}
dic2 = {}
for i in range(1,N+1):
    name = sys.stdin.readline().strip()
    dic[name] = i
    dic2[i] = name
for i in range(M):
    question = sys.stdin.readline().strip()
    if question in dic.keys():
        print(dic[question])
    else:
        question = int(question)
        print(dic2[question])

