import sys

N = int(sys.stdin.readline().strip())
M = int(sys.stdin.readline().strip())

graph = []
for i in range(M):
    a, b, c = map(int, sys.stdin.readline().strip().split())
    graph.append([a,b,c])

graph.sort(key = lambda x: x[2])

root = [i for i in range(N+1)]

def find_root(x):
    if root[x] != x:
        root[x] = find_root(root[x])
    return root[x]

def union_root(a,b):
    a = find_root(a)
    b = find_root(b)
    if a > b:
        root[a]=b
    else:
        root[b]=a

ans= 0
for item in graph:
    a, b, c, =item
    if find_root(a) != find_root(b):
        union_root(a,b)
        ans +=c

print(ans)