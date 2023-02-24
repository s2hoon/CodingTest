def solution(array, commands):
    answer = []
    for item in commands:
        newlist = array[item[0]-1:item[1]]
        newlist.sort()
        answer.append(newlist[item[2]-1])
    return answer