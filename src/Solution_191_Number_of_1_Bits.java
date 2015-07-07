/**
 * 
 * Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 */

/*
 * Note: Need this: http://www.tuicool.com/articles/YBbY3m
 * 
 * (n - 1) & n will remove the last 1.
 * 
 */

public class Solution_191_Number_of_1_Bits {
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if (n == 0) {
        	return 0;
        }
        
        int count = 0;
        
        while (n != 0) {
        	 n = n&(n - 1);
             count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	int n = 8;
    	System.out.print(hammingWeight(n));
    }
}
