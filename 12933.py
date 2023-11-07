word = input()


duck = ['q','u','a','c','k']
count = {'q':0,'u':0,'a':0,'c':0,'k':0}

result = []
temp_result = 0
for i in range(len(word)):
    counting = min(count.values())
    
    if counting == 0:
        count[word[i]] +=1

    else:
        result.append(max(count.values()))
        for alp in duck:
            count[alp] -=1
      

if result:
    print(max(result))
else:
    print(-1)    


