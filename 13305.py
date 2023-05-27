N = int(input())
wire = list(map(int,input().split()))
money = list(map(int, input().split()))
temp = money[0]
bought = 0


for i in range( len(money)-1):
    if temp > money[i]:
        temp = money[i]
    bought += temp* wire[i]
    
print(bought)


# 5 2 4 1 
# 5 2 6 4 1