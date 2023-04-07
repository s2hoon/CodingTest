A, B = map(int, input().split())
A =str(A)
B =str(B)
list_A = list(A)
list_B = list(B)

list_A[0],list_A[2] = list_A[2],list_A[0]
list_B[0],list_B[2] = list_B[2],list_B[0]

joinA=''.join(list_A)
joinB= ''.join(list_B)
if joinA > joinB:
    print(joinA)
else:
    print(joinB)



