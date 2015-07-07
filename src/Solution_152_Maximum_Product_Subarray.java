/**
 * 
 * Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 */

/*
 * Note: Need maxcopy, or the max value will be changed.
 */

public class Solution_152_Maximum_Product_Subarray {
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return A[0];
		}
		
		int min = A[0];
		int max = A[0];
		int result = A[0];
		
		for (int i = 1; i < A.length; i++) {
			int maxcopy = max;
			max = Math.max(Math.max(A[i] * max, A[i]), A[i] * min);
			min = Math.min(Math.min(A[i], A[i] * maxcopy), A[i] * min);
			result = Math.max(max, result);
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int[] input = {2,3,-2,4};
		System.out.println(maxProduct(input));
	}
}
