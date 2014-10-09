package Code;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Valid_Parentheses {
	public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	
        	if (temp == ')') {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		if (stack.peek() == '(') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	} else if (temp == ']') {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		if (stack.peek() == '[') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	} else if (temp == '}') {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		if (stack.peek() == '{') {
        			stack.pop();
        		} else {
        			return false;
        		}
        	} else {
        		stack.push(temp);
        	}
        }
        
        if (stack.isEmpty()) {
        	return true;
        } else {
        	return false;
        }
    }
	
	public static void main(String[] args) {
		String input = "(){}{}[]";
		boolean result = isValid(input);
		System.out.print(result);
	}
}
