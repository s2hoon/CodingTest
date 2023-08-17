N , K = map(int,input().split())

nums = input()

stack = []

for num in nums: # 배열의 모든 숫자를 돌면서 선택 -> 그리디
    while(stack and stack[-1] < num and K >0): # 그리디 + 스택
        stack.pop()
        K -= 1
    stack.append(num)

if K > 0:
    print(''.join(stack[:-K]))
else:
    print(''.join(stack))

