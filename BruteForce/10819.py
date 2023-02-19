import itertools
N = int(input())
result = 0
final_result = 0
A = list(map(int, input().split()))

A.sort()

nPr = list(itertools.permutations(A, N))



def SUUM():
    global result
    global final_result
    for item in nPr:
        result = 0
        for i in range(N-1):
            result += abs(item[i]-item[i+1])

        final_result = max(final_result,result)

SUUM()
print(final_result)