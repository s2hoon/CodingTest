height = []

for i in range(9):
    height.append(int(input()))

height.sort()
sum1 =sum(height)
a, b= 0, 0
for i in range(9):
    for j in range(i+1, 9):
        if(sum1 - height[i] - height[j] == 100):
            a, b = i,j
            break

height.pop(a)
height.pop(b-1)



for i in range(7):
    print(height[i])
