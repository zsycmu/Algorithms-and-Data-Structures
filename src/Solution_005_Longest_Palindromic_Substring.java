/**
 * 
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 */
/*
 * Note: 1. The i and j for loop is different from others. Please notice that.
 * 		 2. Result should be generate at last. Or it will over time.
 * 		 3. Notice the return type.
 */

public class Solution_005_Longest_Palindromic_Substring {
	public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
        	for (int j = i; j < s.length(); j++) {
        		if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
        			dp[i][j] = true;
        			if (j - i + 1 > max) {
        				max = j - i + 1;
        				start = i;
        				end = j + 1;
        			}
        		}
        	}
        }
        
        return s.substring(start, end);
    }
	
	public static void main(String[] args) {
		String s = "aba";
		System.out.print(longestPalindrome(s));
	}
	
//	public String longestPalindrome(String s) {
//	    if(s == null || s.length()==0)
//	        return "";
//	    boolean[][] palin = new boolean[s.length()][s.length()];
//	    String res = "";
//	    int maxLen = 0;
//	    for(int i=s.length()-1;i>=0;i--)
//	    {
//	        for(int j=i;j<s.length();j++)
//	        {
//	            if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))
//	            {
//	                palin[i][j] = true;
//	                if(maxLen<j-i+1)
//	                {
//	                    maxLen=j-i+1;
//	                    res = s.substring(i,j+1);
//	                }
//	            }
//	        }
//	    }
//	    return res;
//	}
}
