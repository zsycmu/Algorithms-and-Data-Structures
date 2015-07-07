/**
 * 
 * String to Integer (atoi) 
 * 
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * spoilers alert... click to show requirements for atoi.
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 */

/*
 * Note: 1. Take care of the overflow.
 * 		 2. Take care of all the branket to be right.
 * 		 3. There has invalid input, break directly.
 */

public class Solution_008_String_to_Integer_atoi {
	public static int atoi(String str) {
        if (str == null || str.length() == 0) {
        	return 0;
        }
        
        int i = 0;
        int sign = 1;
        str = str.trim();
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
        	if (str.charAt(i) == '-') {
        		sign = -1;
            }
        	i++;
        }
        
        long result = 0;
        
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
        		break;
        	}
        	int temp = str.charAt(i) - '0';
        	result = result * 10 + temp;
        	if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        if (result * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result * sign;
    }
	
	public static void main(String[] args) {
		String input = "-9223372036854775809";
		System.out.println(atoi(input));
	}
}
