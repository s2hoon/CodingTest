import sys
from collections import defaultdict
N , K = map(int, sys.stdin.readline().strip().split())
a = list(map(int, sys.stdin.readline().strip().split()))
left , right = 0, 0 
count = defaultdict(int)
ans = 0
while right < N:
    if count[a[right]] < K:
        count[a[right]] += 1
        right += 1
    else:
        count[a[left]] -= 1
        left += 1
    ans = max(ans, right - left)
print(ans)
