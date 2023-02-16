N = int(input())
N_len = len(str(N))
#시간초과
# count = 0
# for i in range(1,N+1):
#     i = str(i)
#     count += len(i)
# print(count)

count =0 
for i in range(N_len - 1):
    count += 9 * 10 ** i * (i+1)

print(count + (N-10**(N_len-1)+1)*N_len)