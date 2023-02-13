from collections import deque
S = int(input())
visited = [[False for i in range(1000+1)]for j in range(1001)]


def BFS():

    visited[1][0]= True
    queue = deque()
    queue.append((1,0,0))
    while(queue):
        num, clipboard,cnt  =queue.popleft()
        #print(num, clipboard,cnt)
        if num == S:
            print(cnt)
            break
     
        for i in range(3):
            if i ==0:
                new_clipboard , new_num = num, num
            elif i==1:
                new_num , new_clipboard = num +clipboard , clipboard
            else:
                new_num, new_clipboard =num -1 , clipboard
            
            if new_num >= 1001 or new_num < 0 or new_clipboard >= 1001 or new_clipboard < 0 or visited[new_num][new_clipboard]:
                continue

            # 방문처리 후 연산 횟수를 +1 하여 큐에 추가
            visited[new_num][new_clipboard] = True
            queue.append((new_num, new_clipboard, cnt + 1))

            


BFS()