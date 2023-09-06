import sys
N = int(sys.stdin.readline().strip())
nums = list(map(int,sys.stdin.readline().strip().split()))
play = list(map(int,sys.stdin.readline().strip().split()))
ans = []
# + - x // 순
def dfs(result,idx):
    for i in range(4):
        if sum(play) == 0:
                ans.append(result)
                
        if play[i] >= 1:
            temp_result =result
            if i == 0:
                temp_result += nums[idx]
       
            elif i == 1:
                temp_result -= nums[idx]
        
            elif i == 2:
                temp_result *= nums[idx]
             
            elif i == 3:
                if temp_result < 0:
                    temp_result = -(-temp_result // nums[idx])  # 음수 나눗셈 처리
                else:
                    temp_result =temp_result // nums[idx]
              
            play[i] -=1
            dfs(temp_result, idx+1)
            play[i] +=1


dfs(nums[0],1)
ans.sort()
print(ans[-1])
print(ans[0])



    




