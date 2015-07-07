/**
 * 
 * Interleaving String
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 */

public class Solution_097_Interleaving_String {
	public static boolean isInterleave2(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		
		for (int i = 1; i < s1.length() + 1; i++) {
			if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[i][0] = true;
			}
		}
		
		for (int j = 1; j < s2.length() + 1; j++) {
			if (dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
				dp[0][j] = true;
			}
		}
		
		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
				if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
				}
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		return helper(s1, 0, s2, 0, s3, 0);
	}
	
	public  static boolean helper(String s1, int p1, String s2, int p2, String s3, int p3) {
		if (p3 == s3.length()) {
			return true;
		}
		
		if (p1 == s1.length()) {
			return s2.substring(p2).equals(s3.substring(p3));
		}
		
		if (p2 == s2.length()) {
			return s1.substring(p1).equals(s3.substring(p3));
		}
		
		if (s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)) {
			return helper(s1, p1 + 1, s2, p2, s3, p3 + 1) || helper(s1, p1, s2, p2 + 1, s3, p3 + 1);
		} else if (s1.charAt(p1) == s3.charAt(p3)) {
			return helper(s1, p1 + 1, s2, p2, s3, p3 + 1);
		} else {
			return helper(s1, p1, s2, p2 + 1, s3, p3 + 1);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "abc";
		String s3 = "abc";
		
		System.out.print(isInterleave2(s1, s2, s3));
	}
}







/*
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < s1.length() + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        for(int j = 1; j < s2.length() + 1; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }
        for(int i = 1; i < s1.length() + 1; i++) {
            for(int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
*/