from collections import deque


A , B = map(int, input().split())
flag = False
#dp 사용불가(메모리 문제)
#BFS
def BFS(A):
    global flag
    queue = deque()
    queue.append((A, 1))

    while(queue):
        a,b =queue.popleft()
        if a > B:
            continue
        if a == B:
            flag = True
            print(b)
            break
        queue.append((int(str(a)+"1"), b+1))
        queue.append((a*2, b+1))

BFS(A)
if flag == False:
    print("-1")




#TOP-DOWN 완탐? 그리디?
