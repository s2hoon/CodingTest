import sys

N = int(sys.stdin.readline().strip())
homework = list(sys.stdin.readline().strip())
dic ={'B': 0,'R':0}
dic[homework[0]] +=1
for i in range(1, len(homework)):
    if homework[i] != homework[i-1] :
        dic[homework[i]]+=1


result = min(dic['B'],dic['R']) + 1

print(result)