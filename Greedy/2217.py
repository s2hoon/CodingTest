import sys

N = int(sys.stdin.readline().strip())
rope = []
for i in range(N):
    rope.append(int(sys.stdin.readline().strip()))

rope.sort(reverse=True)

temp = rope[0]
for i in range(1,len(rope)):
    if rope[i] * (i+1) >= temp:
        temp = rope[i] * (i+1)
print(temp)
