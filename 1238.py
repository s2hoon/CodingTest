import sys
import heapq
N , M , X = map(int, sys.stdin.readline().split()) # N명 학생 , M개 단방향 도로, X번마을에서 파티
graph = [[] for i in range(N+1)]

for i in range(M):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b,c))

#print(graph)
INF = int(1e9)
def dijkstra(start):
    distance = [INF] * (N+1) # 최단거리를 저장할 배열 (가장 큰 수로 초기화)
    q = []
    heapq.heappush(q, (0,start)) # 처음 시작할 때 최단거리와, 인덱스를 넣어줌
    distance[start] = 0 # 처음 시작할때 최단거리를 0으로 초기화
    while(q):
        dist, now = heapq.heappop(q) # 최단거리, 현재 노드

        if dist > distance[now]: # 이미 처리된 노드라면 무시
            continue
				
        for (next,weight) in graph[now]: # 연결된 노드들 최단거리 업데이트
             if dist + weight < distance[next]: 
                 distance[next] = dist + weight 
                 heapq.heappush(q,(distance[next] ,next)) # 우선순위큐에 삽입


    return distance

ans = 0
for i in range(1, N+1):
    go = dijkstra(i) # i 에서 모든 노드로 가는 최단거리 배열 return
    back = dijkstra(X) # X 에서 모든 노드로 가는 최단거리 배열 return
    ans = max(ans, go[X] +back[i])

print(ans) 