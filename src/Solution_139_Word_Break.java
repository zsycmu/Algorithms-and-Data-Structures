import java.util.Set;

/**
 * 
 * Word Break
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */
/*
 * Notice: 用两重循环来做。注意j循环的末尾要加一。
 */

public class Solution_139_Word_Break {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String str = s.substring(i, j);
                if (dp[i] && wordDict.contains(str)) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[s.length()];
    }
}
