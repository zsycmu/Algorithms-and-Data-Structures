/**
 * 
 * Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * 
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 */

public class Solution_115_Distinct_Subsequences {
	public static int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
        	dp[i][0] = 1;
        }
        
        for (int i = 1; i < m + 1; i++) {
        	for (int j = 1; j < n + 1; j++) {
        		if (S.charAt(i - 1) == T.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        		} else {
        			dp[i][j] = dp[i - 1][j];
        		}
        	}
        }
        
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		String s1 = "rabbbit";
		String s2 = "rabbit";
		
		System.out.print(numDistinct(s1, s2));
	}
}
