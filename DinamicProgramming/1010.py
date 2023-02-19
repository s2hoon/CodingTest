#조합은 itertools말고 팩토리얼을 쓰도록하자
def factorial(n):
    num =1 
    for i in range(n):
        num *= (i+1)
    return num
    


T = int(input())
for i in range(T):
    N , M  = map(int, input().split())
    print(factorial(M)//(factorial(N)*factorial(M-N))) # mCn

