import sys

N = int(sys.stdin.readline().strip())

ziphap = set()
for i in range(N):
    inPut = list(sys.stdin.readline().strip().split(" "))
    flag = False
   
    for idx, item in enumerate(inPut):
        if item[0].upper() not in ziphap:
            ziphap.add(item[0].upper())
            flag = True
            item = '[' + item[0] + ']' + item[1:]
            inPut[idx] = item
            print(' '.join(inPut))
            break

        
    if flag == False:
        string=' '.join(inPut)
        for i in range(len(string)):
            if string[i].upper() not in ziphap and string[i]!=' ':
                ziphap.add(string[i].upper())
                flag = True
                string = string[:i] + '[' + string[i] + ']' + string[i+1:]
                print(string)
                break
        
    if flag == False:
        print(' '.join(inPut))
