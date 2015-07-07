/*
 * Remove Duplicates from Sorted Array II Total Accepted: 36925 Total Submissions: 120416 My Submissions Question Solution 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 */


public class Solution_080_Remove_Duplicates_from_Sorted_Array_II {
	public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        
        int count = 1;
        int index = 1;
        
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1]) {
        		count++;
        	} else {
        		count = 1;
        	}
        	if (count <= 2) {
        		A[index] = A[i];
        		index++;
        	}
        }
        
        return index;
    }
	
	public static void main(String[] args) {
		int[] input = {1,1,1,1,2,2,2,3};
		System.out.print(removeDuplicates(input));
	}
}
