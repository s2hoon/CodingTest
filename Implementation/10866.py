import sys
from collections import deque
N = int(input())
dq = deque()

for i in range(N):
    command = list(sys.stdin.readline().strip().split())

    if command[0] == "push_front":
        dq.appendleft(command[1])
    elif command[0] == "push_back":
        dq.append(command[1])
    elif command[0] == "pop_front":
        if dq:
            print(dq.popleft())
        else:
            print(-1)
    elif command[0] == "pop_back":
        if dq:
            print(dq.pop())
        else:
            print(-1)
    elif command[0] == "size":
        print(len(dq))
    elif command[0] == "empty":
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if dq:
            print(dq[0])
        else:
            print(-1)
    elif command[0] == "back":
        if dq:
            print(dq[-1])
        else:
            print(-1)


