N = int(input())
count = 0
for t in range(1,N+1):
    if t < 10 :
        count +=1
        continue

    M = list(map(int, str(t)))
    tmp =M[0] - M[1]
    check = True
    for i in range(len(M)-1):
        if M[i+1] is not None:
            if (M[i] - M[i+1]) != tmp:
                check =False
    
    if check ==True:
        count+=1


print(count) 

