N, K = map(int, input().split())

queue = []
ans = []

for i in range(1,N+1):
    queue.append(i)

cur = 0
while(queue):
    cur += K - 1
    if cur >= len(queue):
        cur = cur % len(queue)
    ans.append(queue.pop(cur))

print("<" + ", ".join(str(x) for x in ans) + ">")







