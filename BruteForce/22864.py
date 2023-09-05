A, B, C, M = map(int,input().split())

#한 일  3 + 3 + 0 + 0 + 0 + 3 + 0
#피로도 5   10  8   6   4   9   7
#시간   1   2   3   4   5   6   7

hour = 24
worked = 0
spend = 0
limit = M
while(hour>0):
    
    # 피로도가 조건을 만족한다면
    if (spend + A) <= limit:
        worked += B
        spend += A
        
      
    else:
        spend -= C
        spend = max(0,spend)

    hour -=1


print(worked)