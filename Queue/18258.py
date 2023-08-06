from collections import deque
import sys
N = int(sys.stdin.readline())
queue = deque()
for i in range(N):
    word = sys.stdin.readline().strip()

    if "push" in word:
        num = int(word[5:])
        queue.append(num)
  
    elif "pop" in word:
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif "size" in word:
        print(len(queue))
    elif "empty" in word:
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif "front" in word:
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    elif "back" in word:
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])

  