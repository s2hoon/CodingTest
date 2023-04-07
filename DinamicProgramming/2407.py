def Fac(x):
    if x == 1:
        return 1
    
    return x * Fac(x-1)

n ,  m = map(int, input().split())
print(Fac(n)//(Fac(n-m)* Fac(m)))


