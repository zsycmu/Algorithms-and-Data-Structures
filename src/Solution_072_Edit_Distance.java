/**
 * 
 * Edit Distance
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 */
/*
 * Note: http://blog.csdn.net/huaweidong2011/article/details/7727482
 * http://www.programcreek.com/2013/12/edit-distance-in-java/
 * 
 */

public class Solution_072_Edit_Distance {
	public static int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return -1;
		}
		if (word1.length() == 0 || word2.length() == 0) {
			return word1.length() == 0 ? word2.length() : word1.length();
		}
		
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
		
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int delete = dp[i - 1][j] + 1;
					int insert = dp[i][j - 1] + 1;
					int replace = dp[i - 1][j - 1] + 1;
					dp[i][j] = Math.min(delete, Math.min(insert, replace));
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {
		String word1 = "word";
		String word2 = "word2";
		
		System.out.print(minDistance(word1, word2));
	}
}
