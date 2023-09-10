natural_num = set(range(1,10001))
generated_num=set()

def d(n):
    if n >= 10001 :
        return
    # n + n 의 각자리수
    t = n
    n_list=list(map(int,list(str(n))))
    for item in n_list:
        t+= item
    if t <= 10000:
        if t not in generated_num:
            generated_num.add(t)
            d(t)


for i in range(10001):
    d(i)
self_num = sorted(natural_num - generated_num)
for item in self_num:
    print(item)
