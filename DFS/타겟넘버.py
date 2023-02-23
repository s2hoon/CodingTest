
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
cnt = 0
def solution(numbers, target):

    answer =0 

    visited = [False for i in range(len(numbers)+1)]
    DFS(0,numbers, visited,target,0)

    answer = cnt
    return answer

def DFS(start, graph, visited,target,value):
    global cnt
    if start == len(graph):
        if value == target:
            cnt+=1
            return

    else:
        if visited[start] == False:

            visited[start] =True
            DFS(start+1 ,graph, visited,target,value+graph[start])
            DFS(start+1 ,graph, visited,target,value-graph[start])
            visited[start] =False