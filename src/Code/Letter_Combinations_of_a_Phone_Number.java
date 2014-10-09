package Code;
import java.util.ArrayList;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *  Input:Digit string "23"
 *  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *  Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Letter_Combinations_of_a_Phone_Number {
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		StringBuilder sb = new StringBuilder();
		helper(result, board, digits, sb, 0);
		return result;
    }
	
	private static void helper(ArrayList<String> result, String[] board, String digits, StringBuilder sb, int start) {
		if (start == digits.length()) {
			result.add(sb.toString());
			return;
		}
		int num = digits.charAt(start) - '0';
		for (int i = 0; i < board[num].length(); i++) {
			sb.append(board[num].charAt(i));
			helper(result, board, digits, sb, start + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> result = letterCombinations("23");
		System.out.println(result);
	}
}
