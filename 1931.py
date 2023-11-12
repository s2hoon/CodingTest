
N = int(input())

stack = []

numbers = []
for i in range(N):
    (a, b)= map(int,input().split())
    numbers.append((a,b))

numbers.sort(key = lambda x : (x[1],x[0]))
stack.append(numbers[0])
for item in numbers[1:]:
    if item[0] >= stack[-1][1]:
        stack.append(item)

print(len(stack))






