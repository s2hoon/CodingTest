

def BruteForce(M,N ,x,y) :
    count = x
    
    while(count <= M*N):
        if (count-x) % M ==0 and (count - y)% N==0:
            return count
        count += M
    return -1



T = int(input())

for i in range(T):
    M, N ,x , y = map(int, input().split())
    print(BruteForce(M,N,x,y))







