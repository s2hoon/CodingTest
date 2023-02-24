def solution(citations):
    answer = 0

    citations.sort()
    
    for idx, item in enumerate(citations):
        if item >= (len(citations) -idx):
            return len(citations) -idx
    return 0  
   
# citations.sort(resverse =True)
# for idx, item in enumerate(citations):
#   if item >= idx:
#       return item
# return 0