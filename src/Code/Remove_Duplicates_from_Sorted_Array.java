package Code;
/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

public class Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        int i;
        int result = 1;
        for (i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1]) {
        		continue;
        	}
        	A[result] = A[i];
        	result++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	int[] A = {1, 1, 2, 2, 3};
    	int result = removeDuplicates(A);
    	System.out.print(result);
    }
}