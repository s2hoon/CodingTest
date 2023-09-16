N = int(input())
peoples =[]
for i in range(N):
    weight, height = map(int,input().split())
    peoples.append((weight, height))

ans = []
for i in range(len(peoples)):
    cnt = 1
    for j in range(len(peoples)):
        if peoples[i][0] < peoples[j][0] and peoples[i][1] < peoples[j][1]:
            cnt += 1
    ans.append(cnt)

print(*ans)