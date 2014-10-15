package Code;
/*
 * Divide two integers without using multiplication, division and mod operator.
 */

public class Divide_Two_Integers {
	public static Integer divide(int dividend, int divisor) {
		if (divisor == 0) {
			return null;
		}
        if (dividend == 0) {
        	return 0;
        }
        int result = 0;
        while (dividend > 0) {
        	dividend = dividend - divisor;
        	result++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int dividend = 6;
		int divisor = 3;
		System.out.print(divide(dividend, divisor));
	}
}
