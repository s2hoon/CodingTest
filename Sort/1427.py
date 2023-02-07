#join 함수 -> list에 있는 문자열 합치기
N = input()
num = []
for i in N:
    num.append(i)

num.sort(reverse=True)
result = ''.join(num)
print(result)