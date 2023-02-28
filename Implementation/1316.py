N= int(input())
cnt = 0
for i in range(N):
    word = input()
    arr = []
    check =True
    arr.append(word[0])
    for i in range(1,len(word)):
        if word[i-1] != word[i]:
            if word[i] in arr:
                check =False
                break
            else:
                check =True
                arr.append(word[i])
                #print(arr)

    if check ==True:
        cnt +=1




print(cnt)

