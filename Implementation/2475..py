
num = list( map(int,input().split()))

#print(num)

sum = 0
for item in num:
    sum += (item ** 2)

result = sum % 10

print(result)