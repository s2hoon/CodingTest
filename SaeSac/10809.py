#문자열.index(i) -> i의 index return
#문자열.find(x) -> x의 index return


S = list(input())
c = 'abcdefghijklmnopqrstuvwxyz'

for i in c:
    if i in S:
        print(S.index(i), end =' ')
    else:
        print(-1, end=' ')