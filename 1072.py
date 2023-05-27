X, Y = map(int, input().split())
first_percent =int(Y/ X * 100)

# count = 0
# while first_percent == int(Y/X*100):
#     X +=1
#     Y +=1
#     count +=1
#     break

# print(count)

#result = 0
start = 0
end = X
while start <= end:
    result = 0
    mid = (start + end)//2
    #print(mid)
    if int(mid / end * 100) == first_percent:
        end +=1
    elif int(mid / end *100) < first_percent:
        start = mid + 1
    else:
        result = mid
        break

print(result)