import java.util.HashSet;

/**
 * 
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
/*
 * Notice: 检查变量名是不是都定义了，返回值和定义的名字要一致。
 */

public class Solution_003_Longest_Substring_Without_Repeating_Characters {
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 0;
        int index = 0;
        HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                int len = i - index + 1;
                max = Math.max(max, len);
                set.add(c);
            } else {
                while (index < s.length() && s.charAt(index) != c) {
                    set.remove(s.charAt(index));
                    index++;
                }
                index++;
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(input));
	}
}
