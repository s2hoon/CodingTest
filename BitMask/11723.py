import sys
M = int(sys.stdin.readline().strip())

bit = 0

for i in range(M):
    command = sys.stdin.readline().strip().split()

    if command[0] == "all" :
        bit = (1 << 20) -1
    elif command[0] == "empty":
        bit = 0
    elif command[0] == "add":
        bit = bit | ( 1 << int(command[1])-1)
    elif command[0] == "remove":
        bit = bit & ~(1 << int(command[1]) -1)
    elif command[0] == "check":
        if bit & (1 << int(command[1])-1) == 0:
            print(0)
        else:
            print(1)
    elif command[0] == "toggle":
        bit = bit ^ (1 << int(command[1])-1)

