package Code;
/*
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class First_Missing_Positive {
	public static int firstMissingPositive(int[] A) {
        //if (A == null || A.length == 0) {
        	return 1;
        }
        
        for (int i = 0; i < A.length - 1; i++) {
        	while (0 < A[i] && A[i] <= A.length) {
        		if (A[i] != i) {
            		swap(A[i], A[A[i]]);
            	} 
        	}
        }
        
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != i) {
        		return i;
        	}
        }
        
        return A.length + 1;
    }
	
	public static void swap (int A, int B) {
		int temp = A;
		A = B;
		B = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10};
		int result = firstMissingPositive(A);
		System.out.print(result);
	}
}
