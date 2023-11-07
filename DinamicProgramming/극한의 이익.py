def solve(numbers):
    print(numbers)

    # Initialize
    dp = [0] * len(numbers)
    dp[0] = numbers[0]
    max_sum = numbers[0]

    for i in range(1, len(numbers)):
        dp[i] = max(numbers[i], dp[i - 1] + numbers[i])
        max_sum = max(max_sum, dp[i])

    print(max_sum)

N = int(input())
numbers = []
for _ in range(N):
    numbers.append(int(input()))

solve(numbers)
