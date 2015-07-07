/**
 * 
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */
/*
 * Notice: 1. 注意递归结束的条件。
 */

import java.util.ArrayList;
import java.util.List;


public class Solution_022_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
        List result = new ArrayList();
        if (n == 0) {
            return result;
        }
        
        StringBuilder sb = new StringBuilder();
        helper(result, sb, n, n);
        
        return result;
    }
    
    public void helper(List result, StringBuilder sb, int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        
        if (left == 0 && right == 0) {
            String temp = sb.toString();
            result.add(temp);
            return;
        }
        
        if (left > 0) {
            sb.append('(');
            helper(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (right > left) {
            sb.append(')');
            helper(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
