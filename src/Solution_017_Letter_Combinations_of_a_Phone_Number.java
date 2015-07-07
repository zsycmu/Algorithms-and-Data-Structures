import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
/*
 * Notice: 1. 注意加到最后result里面的条件。
 * 
 * Time complexity is O(m^n)
 */

public class Solution_017_Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
        List result = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(result, digits, board, sb, 0);
        
        return result;
    }
    
    public void helper(List result, String digits, String[] board, StringBuilder sb, int start) {
        if (sb.length() == digits.length()) {
            String temp = sb.toString();
            result.add(temp);
            return;
        }
        
        for (int i = start; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            String str = board[num];
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                helper(result, digits, board, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
