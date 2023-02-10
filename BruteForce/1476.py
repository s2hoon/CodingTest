E, S , M = map(int, input().split())
#print(E,S,M)
#(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

a,b,c =0,0,0
count = 0
while(1):
    if (a,b,c) == (E,S,M):
        break
    else:
        count += 1
        a += 1
        b += 1
        c += 1
        if a == 16:
            a = 1
        if b == 29:
            b = 1
        if c == 20:
            c = 1
 
  

print(count)