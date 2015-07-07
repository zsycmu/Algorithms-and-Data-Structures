/**
 * 
 * Excel Sheet Column Number
 * 
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *
 */
/*
 * Notice: result = result * 26 + (c - 'A' + 1);
 */

public class Solution_171_Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }
        
        return result;
    }
}
