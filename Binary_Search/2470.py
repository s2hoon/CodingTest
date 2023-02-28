#two pointer
N = int(input())

num = list(map(int, input().split()))
num.sort()
#print(num)
start_index =0
end_index = N-1

result = abs(num[start_index] + num[end_index])
final = (num[start_index],num[end_index])

while start_index < end_index:
    left = num[start_index]
    right = num[end_index]

    temp_result = left + right

    if abs(temp_result) < result:
        result = abs(temp_result)
        final = (left, right)
        if result == 0:
            break
    if temp_result < 0:
        start_index +=1
    else:
        end_index -=1

print(*final)
        


