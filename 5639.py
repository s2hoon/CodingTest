import sys
sys.setrecursionlimit(10**9)
numbers = []
while True:                            
    try:
        numbers.append(int(sys.stdin.readline()))
    except:
        break
def reculsive(start, end):
    if start > end:
        return
    mid = end + 1

    for i in range(start + 1, end +1):
        if numbers[start] < numbers[i]:
            mid = i
            break
    #왼쪽
    reculsive(start + 1, mid-1)
    #오른쪽
    reculsive(mid ,  end)
    print(numbers[start])



print(numbers)
reculsive(0, len(numbers) - 1)



