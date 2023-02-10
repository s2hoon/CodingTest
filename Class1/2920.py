import copy

num = list(map(int,input().split()))
num2 = copy.deepcopy(num)

num.sort(reverse=True)
num.sort(reverse=False)
if num2 != num:
    num.sort(reverse=True)
    if num2 != num:
        print("mixed")
    else:
        print("descending")
else:
    print("ascending")
