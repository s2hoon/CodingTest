word = input()
pockbal = list(input())
length = len(pockbal)

stack = []

for alpha in word:
    stack.append(alpha)
    if len(stack) >= len(pockbal):
        while(stack[-len(pockbal):]==pockbal):
            for i in range(len(pockbal)):
                stack.pop()

if stack:
    print(''.join(stack))
else:
    print("FRULA")
    


