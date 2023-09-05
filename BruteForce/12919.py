
S = list(input())
T = list(input())
def reverse(T):
    temp = []
    for i in range(len(T)-1,-1,-1):
        temp.append(T[i])
    return temp
def dfs(T):
    if T == S: # 종료조건
        return 1
    if T != S and len(T)==1:
        return 0
    if T[0] == 'A' and T[-1] == 'B': #종료조건
        return 0
    elif T[0] == 'B' and T[-1] == 'A':
        tempT = reverse(T)
        tempT.pop()
        T.pop()
        return dfs(T), dfs(tempT)
    elif T[0] == 'B' and T[-1] == 'B': 
        tempT = reverse(T)
        tempT.pop()
        return dfs(tempT)
    
    elif T[0] == 'A' and T[-1] == 'A': 
        T.pop()
        return dfs(T)

print(dfs(T))


