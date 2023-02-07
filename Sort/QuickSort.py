#퀵정렬
#피벗 + 재귀적 방식
array= [7,5,9,0,3,1,6,12]

def quick_sort(array, start, end):
    if start>=end:
        return
    pivot = start
    left = start +1 
    right = end
    while(left <= right):#엇갈릴때까지 반복
        while(left <= end and array[left] <=array[pivot]): #피벗보다 큰데이터를 찾을때까지 반복
            left+=1
        while(right> start and array[right]>=array[pivot]): #피벗보다 작은데이터를 찾을떄까지 반복
            right-=1
        if(left >right): #엇갈렸다면 작은 데이터와 피벗을 교체
            array[right],array[pivot] = array[pivot],array[right]
        else: #엇갈리지 않았다면 작은데이터와 큰데이터를 교체
            array[right],array[left] = array[left],array[right]
    #재귀
    quick_sort(array,start,right-1)
    quick_sort(array, right+1, end)


def quick_sort2(array):
    if len(array)<=1:
        return array
    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x<=pivot]
    right_side = [x for x in tail if x > pivot]

    return quick_sort2(left_side)+ [pivot] +quick_sort2(right_side)
    



quick_sort(array, 0 , len(array)-1)
print(array)