# problems I didn't solve

Mini calculator 
https://leetcode.com/problems/basic-calculator/
```python
class Solution:
    def calculate(self, s: str) -> int:
        if (s.isnumeric()):
            return int(s)
        result = 0
        stack = []
        i = 0
        while (i < len(s)):
            # getting the next digit
            c = s[i]
            while (i + 1 < len(s) and s[i].isnumeric() and s[i + 1].isnumeric()):
                c += s[i + 1]
                i += 1
            if (c == ' '):
                i += 1
                continue
            if (c.isnumeric() and len(stack) >= 1):
                if (stack[-1] == '+'):
                    stack.pop()
                    lNum = stack.pop()
                    val = str(int(lNum) + int(c))
                    stack.append(val)
                    i += 1
                    continue
                elif (stack[-1] == '-'):
                    stack.pop()
                    lNum = stack.pop()
                    val = str(int(lNum) - int(c))
                    stack.append(val)
                    i += 1
                    continue
            elif (c == ')'):
                exp = ""
                tok = stack.pop()
                while (tok != '('):
                    exp = tok + exp
                    tok = stack.pop()
                stack.append(str(self.calculate(exp)))
                i += 1
                continue
            
            stack.append(c)
            i += 1
        if (len(stack) > 1):
            return self.calculate(''.join(stack))
        return int(stack[0])
        
```

Solution:

```python
class Solution:

    def evaluate_expr(self, stack):
        
        # If stack is empty or the expression starts with
        # a symbol, then append 0 to the stack.
        # i.e. [1, '-', 2, '-'] becomes [1, '-', 2, '-', 0]
        if not stack or type(stack[-1]) == str:
            stack.append(0)
            
        res = stack.pop()

        # Evaluate the expression till we get corresponding ')'
        while stack and stack[-1] != ')':
            sign = stack.pop()
            if sign == '+':
                res += stack.pop()
            else:
                res -= stack.pop()
        return res       

    def calculate(self, s: str) -> int:

        stack = []
        n, operand = 0, 0

        for i in range(len(s) - 1, -1, -1):
            ch = s[i]

            if ch.isdigit():

                # Forming the operand - in reverse order.
                operand = (10**n * int(ch)) + operand
                n += 1

            elif ch != " ":
                if n:
                    # Save the operand on the stack
                    # As we encounter some non-digit.
                    stack.append(operand)
                    n, operand = 0, 0

                if ch == '(':         
                    res = self.evaluate_expr(stack)
                    stack.pop()        

                    # Append the evaluated result to the stack.
                    # This result could be of a sub-expression within the parenthesis.
                    stack.append(res)

                # For other non-digits just push onto the stack.
                else:
                    stack.append(ch)

        # Push the last operand to stack, if any.
        if n:
            stack.append(operand)

        # Evaluate any left overs in the stack.
        return self.evaluate_expr(stack)
```

## Perfect Squares

https://leetcode.com/problems/perfect-squares/
Brute Force Enumeration
```python
class Solution:
    def numSquares(self, n: int) -> int:
        i = 1
        possibleSquares = []
        while (i ** 2 <= n):
            possibleSquares.append(i ** 2)
            i += 1
        def backtrack(squares, curSum, path):
            nonlocal n
            if curSum == n:
                return len(path)
            if curSum > n:
                return sys.maxsize
            minimum = sys.maxsize
            for neighbor in squares:
                path.append(neighbor)
                minimum = min(minimum, backtrack(squares, curSum + neighbor, path))
                path.pop()
            return minimum
        return backtrack(possibleSquares, 0, [])
```


checkign division
```python
class Solution:
    def numSquares(self, n):
        
        def is_divided_by(n, count):
            """
                return: true if "n" can be decomposed into "count" number of perfect square numbers.
                e.g. n=12, count=3:  true.
                     n=12, count=2:  false
            """
            if count == 1:
                return n in square_nums
            
            for k in square_nums:
                if is_divided_by(n - k, count - 1):
                    return True
            return False

        square_nums = set([i * i for i in range(1, int(n**0.5)+1)])
    
        for count in range(1, n+1):
            if is_divided_by(n, count):
                return count
                
```


## Sum of Subarray Minimums
https://leetcode.com/problems/sum-of-subarray-minimums/
### Brute Force (TLE)
```python
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        result = 0
        for i in range(1, len(arr)):
            left = 0
            right = i
            while (right <= len(arr)):
                result += min(arr[left:right])
                right += 1
                left += 1
        result += min(arr)
        return result
            
```
### Monotonous Stack
```python
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        stack, sums = [], [0] * len(arr)

        for i,n in enumerate(arr):
            while stack and arr[stack[-1]] > n:
                stack.pop()
            j = stack[-1] if stack else -1
            
            sums[i] = sums[j] + (i-j)*n
            stack.append(i)
        
        return sum(sums) % (1_000_000_007)
```


**Comment.** The **first key observation** here is that, for each element `n` (with index `i`) of array `A`, the sum of minima of all subarrays terminating at this element (i.e., `A[0:i+1], A[1:i+1], ..., A[i:i+1]`) breaks up into two parts:

1.  The sum where `n` is the minimum of each subarray. These subarrays extend from `n` to the left until we hit the first value smaller than `n` (with index, let's say, `j`).
2.  The sum with even smaller (than `n`) minimal values. These are all remaining subarrays until we hit the beginning of `A`.

For example, consider `A=[0,1,2,5,8,3,...]`. For its element `3`, we have:

1.  Subarrays `[5,8,3]`, `[8,3]` and `[3]`, with `3` as the minimum.
2.  Subarrays `[0,1,2,5,8,3]`, `[1,2,5,8,3]` and `[2,5,8,3]`, with `0`, `1` and `2` as the respective minima.

The **second key observation** is that:

1.  The first sum can be computed as `n` times the numbers of such subarrays (i.e., `i-j`). It's obvious why.
2.  The second sum is actually the result of this algorithm for the element with index `j`. In the example above, subarrays `[0,1,2,5,8,3]`, `[1,2,5,8,3]` and `[2,5,8,3]` from step `i` has the same minima as subarrays `[0,1,2]`, `[1,2]` and `[2]` from step `j`. This is due to the fact that `j` was constructed (found) as the first index with the value `A[j] < n`. Thus, the minima for subarrays `A[k:j+1]` will survive if we consider `A[k:i+1]` for `k=0,1,...,j`.

To efficiently query index `j` (of the first smaller element to the left of `n`), we maintain a stack of indices for the non-decreasing subsequence of `A`. The reason for using a monostack is that there is no point to store indices for values that break monotonicity, because for each `n` we are looking for the first (to the left) smaller value. All greater values can be safely discarded (popped from the stack) for both this (`n`) and any of next numbers.


## Maximum Profit Job Scheduling
https://leetcode.com/problems/maximum-profit-in-job-scheduling/
Solution
```python
class Solution:
    def jobScheduling(self, st, et, pr):

        jobs, n = sorted(zip(st, et, pr)), len(st)                 # [1] prepare for binary search
        dp = [0] * (n + 1)                                         #     by sorting the jobs
        
        for i in reversed(range(n)):
            k = bisect_left(jobs, jobs[i][1], key=lambda j: j[0])  # [2] look for the first job with 
            dp[i] = max(jobs[i][2] + dp[k], dp[i+1])               #     non-overlapping start time
            
        return dp[0]
```
1. We sort the input by starting time, creating an array of tuples, where the `i` th tuple is the ith ``(starting time, ending time, proft)`` tuple
2. Go top down dp, `bisect_left` returns the index of the leftmost index in jobs that we can put `jobs[i][1]` into, with the starting time being the sorting key
3. So dp[i] stores the maximum profit we can make for all the days starting after **i**


## Arithmetic Slices 2 - Subsequence
https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
```python
class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        # use defaultdict(int) to easily get the difference in arithmetic subsequences ending with ```j```
        dp = [defaultdict(int) for _ in range(len(nums))]
        res = 0
        for i in range(len(nums)):
            for j in range(i):
                
                # We are looking for the number of elements before j in the arithmetic subsequence that has nums[j]-nums[i] as difference.
                dif = nums[j]-nums[i]

                # Simply add it to the result.
                res += dp[j][dif]

                # Increase the number of elements in arithmetic subsequence at i with this dif.
                dp[i][dif] += dp[j][dif]+1
        return res
```

-   1 <= nums.length <= 1000 means, we are looking for a O(n^2) algorithm.  
    => When we are looking at `nums[i]`, we can check everything before `i`.
    
-   When check `nums[i]` with `nums[j]` (j < i), we can construct a arithmetic subsequences with `[..., nums[j], nums[i] ]` ONLY if there is at least one `nums[k]` before `nums[j]`, and `nums[i]-nums[j] == num[j]-nums[k]`.
    
-   Now how many arithmetic subsequences with length >= 3 are ending with [nums[j], nums[i]]? The answer is the number of elements before `j` in the arithmetic subsequence with difference of nums[i]-nums[j].  
    E.g.,  
    arithmetic subsequence = [1,3,5,7], nums[i]=7, nums[j]=5, we can construct 2 arithmetic subsequences ending with [5,7], they are [1,3,5,7] and [3,5,7]. Note that the number of elements before `j` is 2 (i.e., [1,3]).
    
-   So we just need to memorize the number of elements in arithmetic subsequences ending with `j` with different differences.

## Minimum Path Falling Sum:
https://leetcode.com/problems/minimum-falling-path-sum/description/

### Optimal Solution DP:
```python
class Solution:

    def minFallingPathSum(self, A: List[List[int]]) -> int:

        M, N = len(A), len(A[0])

        for i in range(1, M):

            for j in range(N):

                a = A[i - 1][j - 1] if 0 <= j - 1 else float('inf')

                b = A[i - 1][j]

                c = A[i - 1][j + 1] if j + 1 < N else float('inf')

                A[i][j] += min(a, b, c)

        return min(A[M - 1])
```
- We update the matrix as we go. The ith row and jth column of a matrix will store the minimum sum of the path up to that row
- At the end, return the minimum of the last row

### Mine (brute force :( )
```python
```python
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dirs = [(1, -1), (1, 0), (1,1)]
        # where (i, j) is the ith row and jth column
        rows = len(matrix)
        cols = len(matrix[0])
        minSum = math.inf
        def dfs(row, col, sum):
            nonlocal minSum
            if row >= rows or col >= cols or row < 0 or col < 0:
                return
            sum += matrix[row][col]
            if (row >= rows - 1):
                minSum = min(minSum, sum)
                return
            for dir in dirs:
                newRow = row + dir[0]
                newCol = col + dir[1]
                dfs(newRow, newCol, sum)
        for i in range(cols):
            dfs(0, i, 0)
        return minSum
```

## Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/description/


```python
```python
from functools import lru_cache

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        @lru_cache(maxsize=None)
        def memo_solve(p1, p2):
            
            # Base case: If either string is now empty, we can't match
            # up anymore characters.
            if p1 == len(text1) or p2 == len(text2):
                return 0
            
            # Option 1: We don't include text1[p1] in the solution.
            option_1 = memo_solve(p1 + 1, p2)
            
            # Option 2: We include text1[p1] in the solution, as long as
            # a match for it in text2 at or after p2 exists.
            first_occurence = text2.find(text1[p1], p2)
            option_2 = 0
            if first_occurence != -1:
                option_2 = 1 + memo_solve(p1 + 1, first_occurence + 1)
            
            # Return the best option.
            return max(option_1, option_2)
                
        return memo_solve(0, 0)
```
## Best time to Buy and Sell stock with CD
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

My implementation (fail)
```python
class Solution:

    def maxProfit(self, prices: List[int]) -> int:

        n = len(prices)

        if n == 1:

            return 0

        _min = prices[0]

        answers = [0] * (n + 1)

        for i in range(1, n):

            profit = prices[i] - _min

            maxFromCD = 0

            if i >= 3:

                maxFromCD = max(answers[:(i - 2)])

            answers[i] = max(profit, profit + maxFromCD, maxFromCD)

            _min = min(_min, prices[i])

        print(answers)

        return max(answers)
```

## Solution
```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        sold, held, reset = float('-inf'), float('-inf'), 0

        for price in prices:
            # Alternative: the calculation is done in parallel.
            # Therefore no need to keep temporary variables
            #sold, held, reset = held + price, max(held, reset-price), max(reset, sold)

            pre_sold = sold
            sold = held + price
            held = max(held, reset - price)
            reset = max(reset, pre_sold)

        return max(sold, reset)
```

### another DP solution

```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        L = len(prices)
        # padding the array with additional zero to simply the logic
        MP = [0] * (L + 2)

        for i in range(L-1, -1, -1):
            C1 = 0
            # Case 1). buy and sell the stock
            for sell in range(i + 1, L):
                profit = (prices[sell] - prices[i]) + MP[sell + 2]
                C1 = max(profit, C1)

            # Case 2). do no transaction with the stock p[i]
            C2 = MP[i + 1]

            # sum up two cases
            MP[i] = max(C1, C2)

        return MP[0]
```

## Minimum arrows to pop balloon
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

```python
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x:x[1])
        res, curEnd = 1, points[0][1]
        for start,end in points:
            if start > curEnd:
                curEnd = end
                res += 1
        return res
```
Idea: keep track of curEnd (ie, max we can go to), keep iterating through points until the start is greater than the end, then "pop" those balloons, (increment result) and update endpoint
- Greedy algorithm


## maxsubarraySumCircular
```python
class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        Sum = sum(nums)
        res = nums[0]
        maxSub = nums[0]
        minSub = 0
        for i in range(1,len(nums)):
            maxSub = max(maxSub+nums[i], nums[i])
            minSub = min(minSub+nums[i], nums[i])
            res = max(res, maxSub, Sum - minSub)
        return res
```
DP approach, we think about two things: the maximum subarray normally, and the maximum subarray only circular, where we connect the end to the beginning of the array. Our answer is the maximum of these two. 

The first problem can be solved using DP, for the ith element in nums, we either (1) add it to the end of the subarray ending with i-1 element, or (2) we start a new subarray from i.

Base case: For the first element in nums, the maximum non-empty subarray is nums[0].
DP equation: dp[i] = max(dp[i-1]+nums[i], nums[i])
The second problem can be view as to find the minimum sum subarray in nums without the circular property. What this means is if the maximum subarray is formed by connecting the end to the beginning of the array, we can compute it with sum(nums) - minimum subarray.

So we can use the same dp algorithm as for problem 1, but try to find the minimum subarray.

Base case: Since the subarray is non-empty , our base case is dp[0] = 0, means at least the first element should be included in the answer.
DP equation: dp[i] = min(dp[i-1]+nums[i], nums[i])




## Subarray sums divisible by k
https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

Premise: keep track of a prefix sum array that stores the prefix sum modulo k. 
- We will find that if prefix[i] == prefix[j], then the array from indices (i + 1 ... j) is divisible by k. 
- prefix [i] = (arr[0] + arr[1] + ... + arr[i] % k).


```python
class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        prefixMod, result = 0, 0

        modGroups = [0] * k
        modGroups[0] = 1

        for num in nums:
            prefixMod = (prefixMod + num) % k
            result += modGroups[prefixMod]
            modGroups[prefixMod] += 1

        return result
```

## Best team with no conflicts
https://leetcode.com/problems/best-team-with-no-conflicts/


```Java
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = ages.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        // Initially, all states are null, denoting not yet calculated.
        Integer[][] dp = new Integer[n][n];

        return findMaxScore(dp, ageScorePair, -1, 0);
    }

    private int findMaxScore(Integer[][] dp, int[][] ageScorePair, int prev, int index) {
        // Return 0 if we have iterated over all the players.
        if (index >= ageScorePair.length) {
            return 0;
        }

        // We have already calculated the answer, so no need to go into recursion.
        if (dp[prev + 1][index] != null) {
            return dp[prev + 1][index];
        }

        // If we can add this player, return the maximum of two choices we have.
        if (prev == -1 || ageScorePair[index][1] >= ageScorePair[prev][1]) {
            return dp[prev + 1][index] = Math.max(findMaxScore(dp, ageScorePair, prev, index + 1),
                    ageScorePair[index][1] + findMaxScore(dp, ageScorePair, index, index + 1));
        }

        // This player cannot be added; return the corresponding score.
        return dp[prev + 1][index] = findMaxScore(dp, ageScorePair, prev, index + 1);
    }

}
```
Store the ages and scores of all the players in the list ageScorePair.

Sort the list ageScorePair in ascending order of age and then in ascending order of score.

Iterate over the players; start with index = 0 and prev = -1, as we haven't chosen any player yet.

If it's the first player (prev = -1) or the player's score at index is more than the score of the player at index prev. Then we can add this player, and the score will be the maximum of the two choices we have.

If we add this player, we will add the score, and the value of prev will be the current index index, and move on to the next player, i.e., index + 1.
If we don't add this player, the value of prev won't change and move on to the next player.
If the above two conditions are not satisfied, we only have the option to leave this player and move on to the next one.

Base condition: If we have iterated over all the players, we should return 0.
