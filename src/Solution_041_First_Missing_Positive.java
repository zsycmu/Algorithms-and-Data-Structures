/**
 * 
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 */

/*
 * Notice: 
 */

public class Solution_041_First_Missing_Positive {
	public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
        	return 1;
        }
        
        for (int i = 0; i < A.length; i++) {
        	while (i < A.length && A[i] != i + 1) {
        		if (A[i] - 1 < A.length - 1 && A[i] > 0 && A[i]!=A[A[i]-1]) {
        			swap (A, i, A[i] - 1);
        		} else {
        			break;
        		}
        	}
        }
        
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != i + 1) {
        		return i + 1;
        	}
        }
        
        return A.length + 1;
    }
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 1};
		System.out.print(firstMissingPositive(input));
	}
}
