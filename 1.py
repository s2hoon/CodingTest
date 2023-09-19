def check(word, answer):
    if len(word) == 1 and word[0] == 'a':
        return answer.append(True)
    if len(word) >= 2:
        if word[0] == 'a':
            word = word[1:]
        elif word[-1] == 'a':
            word = word[:-1]
        elif word[0] == 'b' and word[-1] == 'b':
            word = word[1:-1]
        else: 
            return answer.append(False)
    
        check(word,answer)
    return answer.append(False)

answer = 'abababa'



print(answer[1:-1])