# 조건 1 : 큰 문제를 작은 문제로 나눌수있다
# 조건 2 : 동일한 작은 문제를 반복적으로 해결한다
# 메모이제이션 -> 한번 계산한 결과를 메모리 공간에 메모하는 기법 (캐싱이라고도함) 
# DP 테이블 -> 결과 저장용 리스트


d = [0] * 100
def fibo_topdown(x):
    if x ==1  or x ==2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = fibo_topdown(x-1) + fibo_topdown(x-2)
    return d[x]

def fibo_bottomup(x):
    d[1] =1
    d[2] =1
    n = 99

    for i in range(3, n=1):
        d[i] = d[i-1] +d[i-2]

print(fibo_topdown(99))