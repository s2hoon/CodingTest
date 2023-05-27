def binary(start, end, target, array):
    while start<= end:
        mid = (start + end) //2

        if array[mid] == target:
            return 1
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return 0




T = int(input())
for i in range(T):
    N = int(input())
    suchup1 = list(map(int, input().split()))
    M = int(input())
    suchup2 = list(map(int, input().split()))
    suchup1.sort()
    for j in range(M):
        result =binary(0, N-1, suchup2[j], suchup1 )
        print(result)





    