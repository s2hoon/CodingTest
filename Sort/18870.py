#set 함수, dictionary 사용
N = int(input())

index = []
result = []
number = list(map(int, input().split()))
#print(number)
numset = set(number)
a = list(numset)
a.sort()
#print(a)

numdict = {}
for i in range(len(a)):
    numdict[a[i]] =i
#print(numdict)
for i in number:
    print(numdict[i], end=' ')





    
