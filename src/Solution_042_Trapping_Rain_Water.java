/**
 * 
 * Trapping Rain Water 
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 */

/*
 * Notice:
 */

public class Solution_042_Trapping_Rain_Water {
	public static int trap(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        
        int result = 0;
        
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int leftMax = A[0];
        int rightMax = A[A.length - 1];
        
        for (int i = 1; i < left.length; i++) {
        	left[i] = leftMax;
        	if (A[i] > leftMax) {
        		leftMax = A[i];
        	}
        }
        
        for (int i = right.length - 1; i >= 0; i--) {
        	right[i] = rightMax;
        	if (A[i] > rightMax) {
        		rightMax = A[i];
        	}
        }
        
        for (int i = 1; i < A.length - 1; i++) {
        	int value = Math.min(left[i], right[i]) - A[i];
        	if (value > 0) {
        		result = result + value;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.print(trap(input));
	}
}
