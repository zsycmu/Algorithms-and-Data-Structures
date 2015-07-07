import java.util.List;

/**
 * 
 * Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 */
/*
 * Notice: time complexity: O(m * n).
 */

public class Solution_014_Longest_Common_Prefix {
	public String longestCommonPrefix(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        
        String result = strs.get(0);
        
        for (int i = 1; i < strs.size(); i++) {
            String temp = strs.get(i);
            int index = 0;
            while (index < result.length() && index < temp.length() && result.charAt(index) == temp.charAt(index)) {
                index++;
            }
            result = result.substring(0, index);
        }
        
        return result;
    }
}
