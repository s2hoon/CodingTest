A = int(input())
B = int(input())
C = int(input())

result = A * B * C
str_result = str(result)
list_result = list(map(int,str_result))
count = [0 for i in range(10)]
for item in list_result:
    count[item] +=1

for item in count:
    print(item)