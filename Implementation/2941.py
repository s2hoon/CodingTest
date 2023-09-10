word = input()
cro = ["c=","c-","dz=","d-","lj","nj","s=","z="]
ans = 0

while(len(word)!=0):
    if word[-3:] in cro:
        word = word[:-3]
        ans +=1
    elif word[-2:] in cro:
        word = word[:-2]
        ans +=1
    else:
        word =word[:-1]
        ans +=1

print(ans)