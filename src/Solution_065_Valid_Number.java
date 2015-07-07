/**
 * 
 * Valid Number
 * 
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 */

/*
 * Note: number has three forms: int, float and e.
 * 
 */

public class Solution_065_Valid_Number {
	public static boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
        	return false;
        }
        int e = s.length() - 1;
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
        	i++;
        }
        
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        
        while (i <= e) {
        	char c = s.charAt(i);
        	
        	if (Character.isDigit(c)) {
        		num = true;
        	} else if (c == '.') {
        		if (exp || dot) {
        			return false;
        		}
        		dot = true;
        	} else if (c == 'e') {
        		if (exp || num == false) {
        			return false;
        		}
        		num = false;
        		exp = true;
        	} else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            } else {
        		return false;
        	}
        	i++;
        }
        
        return num;
    }
	
	public static void main(String[] args) {
		String input = "+1e";
		System.out.println(isNumber(input));
	}
}
