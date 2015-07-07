/**
 * Decode Ways Total
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 */

/*
 * Note: This one is like a climb stair, the difference is to check whether the last step is valid or not.
 * For reference: http://www.cnblogs.com/springfor/p/3896162.html
 */

public class Solution_091_Decode_Ways {
	public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        if (isValid(s.substring(0,1))) {
        	dp[1] = 1;
        } else {
        	dp[1] = 0;
        }
        
        for (int i = 2; i <= s.length(); i++) {
        	String temp = s.substring(i - 1, i);
        	if (isValid(temp)) {
        		dp[i] = dp[i] + dp[i - 1];
        	}
        	temp = s.substring(i - 2, i);
        	if (isValid(temp)) {
        		dp[i] = dp[i] + dp[i - 2];
        	}
        }
        
        return dp[s.length()];
    }
	
	public static boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return false;
		}
		int temp = Integer.parseInt(s);
		return temp >= 1 && temp <= 26;
	}
	
	public static void main(String[] args) {
		String input = "122";
		System.out.print(numDecodings(input));
	}
}
