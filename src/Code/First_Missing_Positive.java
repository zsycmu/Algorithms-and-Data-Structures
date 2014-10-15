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
        if (A == null || A.length == 0) {
        	return 1;
        }
        
        for (int i = 0; i < A.length; i++) {
        	while (0 < A[i] && A[i] <= A.length && A[i] != (i + 1)) {
                if (A[A[i] - 1] == A[i]) {
                    break;
                }
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != i + 1) {
        		return i + 1;
        	}
        }
        
        return A.length + 1;
    }
	
	
	public static void main(String[] args) {
		int[] A = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10};
		int result = firstMissingPositive(A);
		System.out.print(result);
	}
}
