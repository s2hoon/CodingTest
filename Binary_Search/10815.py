N = int(input())
a= list(map(int, input().split()))
M = int(input())
b= list(map(int, input().split()))

a.sort()
def binary_search(start, end, target,array):
    while start <= end:
        mid = (start + end) //2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid -1
        else: 
            start = mid +1
    return None




for i in range(M):
    temp_result =binary_search(0, N-1, b[i], a)
    if  temp_result is not None:
        print(1,end =' ')
    else:
        print(0,end =' ')

