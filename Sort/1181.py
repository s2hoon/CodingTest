#sys.stdin.readline().strip()
#array.sort(key = len)

import sys

N = int(input())
word = []
for i in range(N):
    word.append(sys.stdin.readline().strip())
words=list(set(word))
words.sort()
words.sort(key = len)

# def InsertSort(array):
#     for i in range(1, len(array)):
#         for j in range(i , 0, -1):
#             if len(array[j]) < len(array[j-1]):
#                 array[j],array[j-1] = array[j-1] ,array[j]
#             elif len(array[j]) == len(array[j-1]):
#                 if array[j] < array[j-1]:
#                     array[j],array[j-1] = array[j-1] ,array[j]
#             else:
#                 break
#     return array
# result = InsertSort(words)

for i in words:
    print(i)