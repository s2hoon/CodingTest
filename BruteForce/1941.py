from itertools import combinations
from collections import deque
arr = []
for i in range(5):
    arr.append(list(input()))
dx = [0,0,1,-1]
dy = [1,-1,0,0]
positions = [(i,j) for i in range(5) for j in range(5)]
combs = list(combinations(positions,7))
#DFS나 BFS로는 십자가 모양을 구현하기 힘듬
#따라서 조합으로 완전탐색을 구현후, 모든 조합에서 BFS로 이어져있지않은거 체크, S가 4개있지않은거 체크
def BFS(comb):
    visited = [[False for i in range(5)] for j in range(5)]
    a, b =comb[0]
    visited[a][b] =True
    queue = deque()
    queue.append((a,b))
    cnt = 1

    while(queue):
        x, y=queue.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if nx >= 5 or nx < 0 or ny >= 5 or ny <0:
                continue

            if visited[nx][ny]== False and (nx,ny) in comb:
                queue.append((nx,ny))
                visited[nx][ny] = True
                cnt +=1

    if cnt == 7:
        return True
    else:
        return False
    



def checkS(comb):
    count = 0
    for item in comb:
        a, b = item
        if arr[a][b] =='S':
            count +=1
    
    if count == 4:
        return True
    else:
        return False

answer =0
for comb in combs:
    if checkS(comb):
        if BFS(comb):
            answer+=1

print(answer)
