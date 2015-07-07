/**
 * 
 * Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
/*
 * Notice: 1. remember this: Character.isLetterOrDigit(c1)
 * 		   2. 问是不是全是valid的字符
 */
public class Solution_125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        s = s.trim();
        s = s.toLowerCase();
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if (!Character.isLetterOrDigit(c1)) {
                start++;
            } else if (!Character.isLetterOrDigit(c2)) {
                end--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        
        return true;
    }
}
