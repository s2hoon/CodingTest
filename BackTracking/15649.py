N , M =map(int, input().split())
visited =[False for i in range(N+1)]
answer = []

def BackTracking(answer,visited):
    if len(answer) == M:
        print(' '.join(map(str, answer)))#map 을 활용하여 모든 변수 형변환
       

    for i in range(1, N+1):
        if visited[i] ==False:
            visited[i] =True
            answer.append(i)
            BackTracking(answer, visited)
            answer.pop()
            visited[i] =False

BackTracking(answer,visited)
