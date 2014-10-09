package Code;
import java.util.ArrayList;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *  "((()))", "(()())", "(())()", "()(())", "()()()"
 */

// Solution: Greedy and Recursive
// Take advantage of the feature of parentheses, left side and right side must match each other, in other words, 
// if there a left side parentheses, whatever position it is, there must be a right side parentheses to match it.

public class Generate_Parentheses {
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n < 2) {
			return result;
		}
		StringBuilder temp = new StringBuilder();
		helper(result, n, n, temp);
		return result;
    }
	
	private static void helper(ArrayList<String> result, int left, int right, StringBuilder temp) {
		if (left == 0 && right == 0) {
			result.add(temp.toString());
			return;
		}
		
		if (left > 0) {
			temp.append("(");
			helper(result, left - 1, right, temp);
			temp.deleteCharAt(temp.length() - 1);
		}
		
		if (right > left) {
			temp.append(")");
			helper(result, left, right - 1, temp);
			temp.deleteCharAt(temp.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> result = generateParenthesis(n);
		System.out.println(result);
	}
}