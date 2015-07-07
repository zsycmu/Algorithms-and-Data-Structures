/*
 * Sort Colors
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 */

public class Solution_075_Sort_Colors {
	public static void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int i = 0;
        int start = 0;
        int end = A.length - 1;
        
        while (i <= end) {
            if (A[i] == 0) {
                swap(A, i, start);
                start++;
                i++;
            } else if (A[i] == 2) {
                swap(A, i, end);
                end--;
            } else {
                i++;
            }
        }
    }
    
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public static void main(String[] args) {
    	int[] input = {2,1,0,0,1,2};
    	sortColors(input);
    	for (int i = 0; i < input.length; i++) {
    		System.out.print(input[i] + " ");
    	}
    }
}
