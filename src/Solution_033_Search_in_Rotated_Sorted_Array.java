/**
 * 
 * Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 */

/*
 * Note: notice that the if statement has = instead of < or >. 
 */

public class Solution_033_Search_in_Rotated_Sorted_Array {
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		
		while (start + 1 < end) {
			mid = (end - start) / 2 + start;
			if (A[mid] == target) {
				return mid;
			} else if (A[start] < A[mid]) {
				if (A[start] <= target && target <= A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (A[mid] <= target && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}
		
		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		int[] input = {4,5,6,1,2,3};
		System.out.print(search(input, 3));
	}
}
