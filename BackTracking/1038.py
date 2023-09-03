
from itertools import combinations
N = int(input())

nums = set()
for i in range(1, 11):
    for comb in combinations(range(0,10),i):
        comb = list(comb)
        comb.sort(reverse = True)
        nums.add(int(''.join(map(str,comb))))

sor_nums = sorted(nums)
try:
    print(sor_nums[N])
except:
    print(-1)
