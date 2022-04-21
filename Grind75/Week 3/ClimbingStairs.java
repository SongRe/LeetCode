package Grind75.Week 3;

public class ClimbingStairs {
    
}

// brute force, TLE
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2; // either + 1 + 1, or + 2
        }
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

//  kind of like the recursive with memorization
public class Solution {
    public int climbStairs(int n) {
        // memorize the amount of different ways to get to step i 
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    
    // the key is to realize that its the same "up" or "down" the stairs
    public int climb_Stairs(int i, int n, int memo[]) {
        // if our current step is greater than n, then return 0 since we have overstepped (no way to get here)
        if (i > n) {
            return 0;
        }
        
        // only one way to be equal to the destination step
        if (i == n) {
            return 1;
        }
        
        // if this value was saved already 
        if (memo[i] > 0) {
            return memo[i];
        }
        
        // our current step will be the sum of the "next" two steps.
        // if i take 1 step, then the problem becomes the sum of n - 1 steps. If I take two, then its a problem of n- 2 steps. Thus, the amount it takes to get to the current step is steps(n - 1) + steps(n - 2)
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}

// True DP solution
// so simple now that I look at it, just a fib sequence
public class SolutionDP {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
}