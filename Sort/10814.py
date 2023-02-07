#dictionary 정렬 sorted 함수
#sorted_dict = sorted(dic.items(),key = lambda item: (item[1],item[0]))
#arr.sort(key = lambda item: int(item[0]))
import sys

N = int(input())

arr = []

for i in range(N):
    arr.append(list(sys.stdin.readline().split()))


arr.sort(key = lambda item: int(item[0]))

for i in arr:
    print(arr[i][0], arr[i][1])
