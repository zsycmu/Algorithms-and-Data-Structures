/**
 * 
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 */
/*
 * 
 */

public class Solution_135_Candy {
	public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
        	return 0;
        }
        
        int[] dp = new int[ratings.length];
        
        for (int i = 0; i < dp.length; i++) {
        	dp[i] = 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
        	if (ratings[i] > ratings[i - 1] && dp[i] <= dp[i - 1]) {
        		dp[i] = dp[i - 1] + 1;
        	}
        }
        
        for (int i = dp.length - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
        		dp[i] = dp[i + 1] + 1;
        	}
        }
        
        int result = 0;
        
        for (Integer i : dp) {
        	result += i;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {1,3,5};
		System.out.print(candy(input));
	}
}
