from collections import deque

dic = {}

def solution(begin, target, words):
    answer = 0 
    visited = [False for i in range(len(words))]
    depth = [0 for i in range(len(words)+1)]
    
    dic[begin] =0 
    
    if target not in words:
        print(0)
        
    else:
        answer = BFS(begin, words ,visited,target,depth)
        
    return answer


def checkword(word1,word2):
    cnt =0
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            cnt+=1 
    if cnt ==1:
        return True
    else:
        return False
    


def BFS(begin, words ,visited,target,depth):

    queue =deque()
    queue.append(begin)
    while(queue):
        word = queue.popleft()
        if word == target:
            return dic[word]

        for i in range(len(words)):
            if visited[i] == False and checkword(word, words[i]):
                #print(word, words[i])
                dic[words[i]]=dic[word] +1
                queue.append(words[i])
                visited[i]=True


            
            
    
    

    
    
    
    
    
    
    
    
    
    