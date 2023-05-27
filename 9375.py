# dictionary
# get함수
# set함수
# dic.get(word2) is None:
# dic[word2] = set()
# dic.keys()


T = int(input())

for i in range(T):
    result = 0
    dic = {}
    N = int(input())
    for j in range(N):
        word, word2 = input().split()
        if dic.get(word2) is None:
            dic[word2] = set()
        dic[word2].add(word)
    
    
    count =1 
    for key in dic.keys():
        count *= (len(dic[key]) +1)
    print(count -1)




  



