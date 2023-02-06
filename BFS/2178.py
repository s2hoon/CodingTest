

# ex) 본문제랑 관련없음
# 1. 아이디어
# - 2중 for -> 값 1 && 방문x -> BFS
# - BFS 돌면서 그림개수 +1 , 최대값을 갱신

# 2. 시간복잡도
# - BFS: O(V+@)
# - V : 500 * 500
# - E : 4 *500 * 500
# - V+E : 5 * 250000 = 100만 < 2억 >> 가능!!

# 3. 자료구조
# - 그래프 전체 지도 : int [][]
# - 방문 : bool[][]
# - Queue(BFS)

# 본문제
# 1. 아이디어 
# - 2중 for문 -> 1 과 0인 값 -> BFS
# 2. 시간복잡도
# 3. 자료구조
# - BFS -> Queue

from collections import deque

dx = [1,-1,0,0]
dy = [0,0,-1,1]

def BFS( x,y ):
    queue =deque()
    queue.append((x,y))
    while(queue):
        x, y = queue.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
           
            #벽을 벗어나면
            if nx >= N or nx < 0 or ny >= M or ny < 0:
                continue
            #벽이 막혀있다면
            if graph[nx][ny]==0:
                continue
            #나머지 가능일떄
            if graph[nx][ny] ==1:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y]+1
    return graph[N-1][M-1]






N , M  = map(int, input().split())
#graph = [[ 0 for i in range(M)] for j in range(N)] #list comprehension
graph = []
for i in range(N):
    graph.append(list(map(int, input())))

print(BFS(0,0))