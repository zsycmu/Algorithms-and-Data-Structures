/**
 * 
 * House Robber
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
/*
 * Note: When the num's length is one, only one house can be robbed.
 * http://blog.csdn.net/sunnyyoona/article/details/44938915
 * 此问题采用动态规划，根据题意，到达第i个房子最大收益应该为第i-2个房子最大收益加上第i个房子钱数与到达第i-1个房子最大收益两者的最大值。
 * dp[i] = Math.max(num[i] + dp[i - 2], dp[i - 1]);
 */

public class Solution_198_House_Robber {
	public static int rob(int[] num) {
        if (num == null || num.length == 0) {
        	return 0;
        }
        
        if (num.length == 1) {
        	return num[0];
        }
        
        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        
        for (int i = 2; i < num.length; i++) {
        	dp[i] = Math.max(num[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[num.length - 1];
    }
	
	public static void main(String[] args) {
		int[] input = {2,1,1,2};
		System.out.print(rob(input));
	}
}
