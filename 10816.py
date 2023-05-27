import copy

N = int(input())
a = list(map(int, input().split()))
M = int(input())
b = list(map(int, input().split()))
dic = {}
for i in range(M):
    dic[b[i]] = 0
b.sort()
def binary_search(start, end, array, target):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return array[mid]
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

for i in range(N):
    result = binary_search(0, M - 1, b, a[i])
    if result is not None:
        if result in dic.keys():
            dic[result] += 1


print(' '.join(map(str,dic.values())))



