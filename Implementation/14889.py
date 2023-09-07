import sys
N = int(sys.stdin.readline().strip())
person = [ i for i in range(1,N+1)]
result = []
graph = []
last = []
for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip().split())))
    
def BackTrack(start,cnt):

    if cnt == N //2 :
        last.append(sum(result))
        return
    

    for i in range(start,N):
        result.append(i)
        BackTrack(i+1,cnt+1)
        result.pop()
        
BackTrack(1,0)
print(last)
print(graph)





                 
