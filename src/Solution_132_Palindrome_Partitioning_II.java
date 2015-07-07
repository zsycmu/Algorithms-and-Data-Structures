/**
 * 
 * Palindrome Partitioning II
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
/*
 * Notice: 对于程序里面if else的地方，如果i==0那么整个字符串到j都是回文串，并不需要切分。
 */

public class Solution_132_Palindrome_Partitioning_II {
	public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        
        for (int j = 0; j < s.length(); j++) {
            cut[j] = j;
            for (int i = 0; i <=j ;i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        cut[j] = 0;
                    }
                } 
            }
        }
        
        return cut[s.length() - 1];
    }
}
