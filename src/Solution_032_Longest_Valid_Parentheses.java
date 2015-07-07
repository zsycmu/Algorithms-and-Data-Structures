

/**
 * 
 * Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 */
/*
 * 
 * Note: You should understand it again.
 * 		 http://blog.csdn.net/jellyyin/article/details/9887959
 * 		 http://www.cnblogs.com/xinsheng/p/3515330.html
 * 
 */

import java.util.Stack;

public class Solution_032_Longest_Valid_Parentheses {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int last = -1;
		int max = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - last);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		String input = "()()())";
		System.out.println(longestValidParentheses(input));
	}
}
