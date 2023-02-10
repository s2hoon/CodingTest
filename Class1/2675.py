T = int(input())


for i in range(T):
    result = []
    R, S = input().split()
    R = int(R)
    for item in S:
        for _ in range(R):
            result.append(item)
    
    resulted = ''.join(result)
    print(resulted)