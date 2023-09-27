import sys
N = int(sys.stdin.readline().strip())
M = int(sys.stdin.readline().strip())
reference = [ i for i in range(N+1)]

def find_root(x):
    if reference[x] != x:
        reference[x] = find_root(reference[x])
    return reference[x] 

def union(a,b):
    a = find_root(a)
    b = find_root(b)
    if a < b:
        reference[b] = a
    else:
        reference[a] = b


for i in range(1,N+1):
    temp = list(map(int,sys.stdin.readline().strip().split()))

    for idx,item in enumerate(temp):
        if item == 1:
            if find_root(i) != find_root(idx+1):
                union(i, idx+1)
            

travel = list(map(int,sys.stdin.readline().strip().split()))
travel.sort()
for item in travel:
    if find_root(item) != travel[0]:
        print("NO")
        exit()


print("YES")


