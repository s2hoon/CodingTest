#itertools.permutation(arr, 3)

import itertools

N= int(input())
arr = [i+1 for i in range(N)]
hi=itertools.permutations(arr,N)
nPr = list(hi)
for i in nPr:
    print(*i)