def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse =True) #최대길이 3자리
    a= ''.join(numbers) #list를 문자열로
    answer = a
    return str(int(answer)) # 000을 0으로 바꿔주기위해서