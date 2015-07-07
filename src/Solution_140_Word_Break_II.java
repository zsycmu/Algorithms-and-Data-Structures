import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution_140_Word_Break_II {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        List result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
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
        
        ArrayList<String> list = new ArrayList<String>();
        helper(result, list, s, wordDict, 0, dp);
        return result;
    }
    
    private static void helper(List result, ArrayList<String> list, String s, Set<String> wordDict, int start, boolean[] dp) {
        if (start == s.length()) {
            String temp = "";
            for (String str : list) {
                temp = temp + str;
                temp = temp + " ";
            }
            temp = temp.trim();
            result.add(temp);
        }
        
        for (int i = start; i < s.length(); i++) {
            if (!dp[i + 1]) {
                continue;
            }
            String temp = s.substring(start, i + 1);
            if (wordDict.contains(temp)) {
                list.add(temp);
                helper(result, list, s, wordDict, i + 1, dp);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
    	String s = "catsanddog";
    	Set<String> set = new HashSet<String>();
    	set.add("cat");
    	set.add("cats");
    	set.add("and");
    	set.add("sand");
    	set.add("dog");
    	
    	System.out.print(wordBreak(s, set));
    }
}
