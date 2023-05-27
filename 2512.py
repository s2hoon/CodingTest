N = int(input())
num = []
num = list(map(int, input().split()))
num2 = []
sanghan = int(input())
#print(num)

#완탐 x

# 모든 요청이 배정될수 있는 경우
if(sum(num)<=sanghan):
    print(max(num))

# 모든 요청이 배정될수 없는 경우
else:
    avg= (sanghan // len(num))
    for item in num:
        if item > avg:
            num2.append(item)
        else:
            sanghan -= item

    result = (sanghan // len(num2))
    print(result)