import java.util.Stack;

/**
 * 
 * Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
/*
 * Notice:
 */

public class Solution_020_Valid_Parentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '(') {
                    continue;
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '[') {
                    continue;
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '{') {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
