# String 함수들
# count 함수, index함수
# upper함수
# lower함수
# ord함수(아스키코드)
# chr함수(아스키코드)


word = input()

upper_word=word.upper()
result = []
count = [ 0 for _ in range(65,91)]

for item in upper_word:
        count[ord(item)-65]+=1

if count.count(max(count))>1:
        print("?")
else:
    print(chr(count.index((max(count)))+65))


