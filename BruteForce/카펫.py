

def solution(brown, yellow):
    answer = []
    final_result = []
    result = []
    for M in range(1,5000):
        for N in range(1, 5000):
            if (2*M +2*(N-2)) == brown:
                result.append([M,N])
    
    for item in result:
        if (item[0]*item[1]) == (brown + yellow ) and (item[0] >= item[1]):
            final_result.append(item)
    
    answer =final_result[0]
    
    
    return answer