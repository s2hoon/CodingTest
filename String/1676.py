import sys
import math
sys.setrecursionlimit(10**6)
N = int(input())

num = math.factorial(N)
count = 0

for item in str(num)[::-1]:
    if item == "0":
        count +=1
    if item != "0":
        break

print(count)



