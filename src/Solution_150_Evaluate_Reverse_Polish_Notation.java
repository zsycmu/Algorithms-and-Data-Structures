import java.util.Stack;

/**
 * 
 * Evaluate Reverse Polish Notation
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
/*
 * 
 */
public class Solution_150_Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        String operation = "+-*/";
        Stack<String> stack = new Stack<String>();
        
        for (String s : tokens) {
            if (!operation.contains(s)) {
                stack.push(s);
            } else {
                int i2 = Integer.parseInt(stack.pop());
                int i1 = Integer.parseInt(stack.pop());
                int temp = 0;
                if (s.equals("+")) {
                    temp = i1 + i2;
                } else if (s.equals("-")) {
                    temp = i1 - i2;
                } else if (s.equals("*")) {
                    temp = i1 * i2;
                } else {
                    temp = i1 / i2;
                }
                stack.push(Integer.toString(temp));
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}
