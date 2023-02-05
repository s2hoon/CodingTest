N= int(input())
A = list(map(int,input().split()))
A.sort()
M = int(input())
B = list(map(int, input().split()))


def binary_search(start, end,array, target ):
    while start <=end:
        mid = (start + end) //2

        if array[mid] ==target:
            return mid
        
        elif array[mid] > target:
            end = mid -1 
        else: 
            start =mid +1 
    return None
            
result = []

for i in B:
    result.append(binary_search(0,N-1,A,i))



for i in result:
    if i is None:
        print(0)
    else: print(1)



# print(A)
# print(B)

