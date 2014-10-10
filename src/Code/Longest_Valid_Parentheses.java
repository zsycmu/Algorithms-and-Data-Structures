package Code;

import java.util.Stack;
/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class Longest_Valid_Parentheses {
	public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int result = 0;
        int index = 0;
        int i = 0;
        Stack<Character> stack = new Stack<Character>();
        for (i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.push(s.charAt(i));
        	} else {
        		if (stack.isEmpty() || stack.peek() != '(') {
        			result = Math.max(result, i - index);
        			index = i;
        			continue;
        		} else {
        			stack.pop();
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		String s = "()()(";
		int result = longestValidParentheses(s);
		System.out.print(result);
	}
}
