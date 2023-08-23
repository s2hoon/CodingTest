import sys

V, E = map(int, sys.stdin.readline().strip().split())

root = [i for i in range(V+1)]
def find_root(x):
    if root[x] != x:
        root[x] = find_root(root[x])
    return root[x]

def union_root(A,B):
    A = find_root(A)
    B = find_root(B)
    if A > B:
        root[A] = B
    else:
        root[B] = A


graph = []
ans = 0

for i in range(E):
    A, B, C = map(int, sys.stdin.readline().strip().split())
    graph.append([A,B,C])

graph.sort(key = lambda x : x[2])

for item in graph:
    A, B, C =item
    if find_root(A) != find_root(B):
        union_root(A,B)
        ans += C
 

print(ans)
        