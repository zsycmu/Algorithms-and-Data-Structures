/**
 * 
 * Factorial Trailing Zeroes
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 */
/*
 * Note: it is a math problem. Just remember it here.
 */

public class Solution_172_Factorial_Trailing_Zeroes {
	public static int trailingZeroes(int n) {
        if (n < 0) {
        	return -1;
        }
        int count = 0;
        for (long i = 5; n / i >= 1; i = i * 5) {
        	count += n / i;
        }
        return count;
    }
	
	public static void main(String[] args) {
		int n = 25;
		System.out.print(trailingZeroes(n));
	}
}
