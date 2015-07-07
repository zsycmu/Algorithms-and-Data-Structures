/**
 * 
 * Climbing Stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */
/*
 * Notice:
 */

public class Solution_070_Climbing_Stairs {
	public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2;  i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n - 1];
    }
}
