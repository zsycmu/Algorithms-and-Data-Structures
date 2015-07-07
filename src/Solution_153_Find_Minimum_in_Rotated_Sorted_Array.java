/**
 * 
 * Find Minimum in Rotated Sorted Array 
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 */

public class Solution_153_Find_Minimum_in_Rotated_Sorted_Array {
	public static int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = num.length - 1;
        int mid = 0;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (num[num.length - 1] < num[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return num[start];
    }
	
	public static void main(String[] args) {
		int[] input = {3, 1, 2};
		int result = findMin(input);
		System.out.println(result);
	}
}
