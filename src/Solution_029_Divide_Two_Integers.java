/**
 * 
 * Divide Two Integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 */
/*
 * Note: 减法的地方要指数倍的减，否则会超时。
 */

public class Solution_029_Divide_Two_Integers {
	public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
        	return 0;
        }
        
        boolean pos = true;
        
        if ((dividend > 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
        	pos = true;
        } else {
        	pos = false;
        }
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        if (b > a) {
        	return 0;
        }
        
        int result = 0;
        while (a >= b) {
        	int shift = 0;
        	
        	while (b << shift <= a) {
        		shift++;
        	}
        	
        	result = result + 1 << (shift - 1);
        	a = a - (b << (shift - 1));
        }
        
        return pos == true ? result : -result;
    }
	
	public static void main(String[] args) {
		System.out.print(divide(25, 5));
	}
}
