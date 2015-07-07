/**
 * 
 * Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 * 
 */

/*
 * Notice:
 */

public class Solution_044_Wildcard_Matching {
	public static boolean isMatch2(String s, String p) {
		int sum = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) != '*')
				sum++;
		}
		if (sum > s.length()) {
			return false;
		}
		int slen = s.length() + 1;
		int plen = p.length() + 1;
		boolean[][] dp = new boolean[slen][plen];
		dp[0][0] = true;
		for (int i = 1; i < plen; i++) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = true;
			else
				break;
		}
		for (int i = 1; i < slen; i++) {
			for (int j = 1; j < plen; j++) {
				if (p.charAt(j - 1) == '*'
						&& (dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1]))
					dp[i][j] = true;
				else if (dp[i - 1][j - 1]
						&& (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s
								.charAt(i - 1))) {
					dp[i][j] = true;
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (s.length() != 0 && p.length() == 0) {
			return false;
		}
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (s.length() == 0) {
			if (p.charAt(0) == '*') {
				return isMatch(s, p.substring(1));
			} else {
				return false;
			}
		}
		if (p.charAt(0) == '*') {
			while (s.length() != 0) {
				if (isMatch(s, p.substring(1))) {
					return true;
				}
				s = s.substring(1);
			}
			return isMatch(s, p.substring(1));
		} else {
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
		String p = "a*******b";
		System.out.print(isMatch(s, p));
	}
}
