n = int(input())
cnt = 0
while(n > 0):
    if n % 5 == 0: # 5로 나눈나머지
        n -= 5
        cnt +=1
    else:
        n -=2 
        cnt+=1

if n < 0:
    print(-1)
else:
    print(cnt)


