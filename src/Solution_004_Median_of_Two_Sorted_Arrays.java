/**
 * 
 * Median of Two Sorted Arrays
 * 
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 */

/*
 * Note: http://blog.csdn.net/yutianzuijin/article/details/11499917/
 * The first place to remember is that we should know the length of the two arrays. Even or odd.
 * Recursive function's first several lines could be the corner cases.
 * 
 */

public class Solution_004_Median_of_Two_Sorted_Arrays {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 == 0) {
			return (helper(A, 0, B, 0, len / 2) + helper(A, 0, B, 0, len / 2 + 1)) / 2.0;
		} else {
			return helper(A, 0, B, 0, len / 2 + 1);
		}
    }
	
	public static double helper(int[] A, int A_start, int[] B, int B_start, int k) {
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}
		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = Integer.MAX_VALUE;
		int B_key = Integer.MAX_VALUE;
		
		if (A_start + k / 2 - 1 < A.length) {
			A_key = A[A_start + k / 2 - 1];
		}
		if (B_start + k / 2 - 1 < B.length) {
			B_key = B[B_start + k / 2 - 1];
		}
		
		if (A_key < B_key) {
			return helper(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return helper(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1 ,2 ,3, 4};
		int[] B = {5, 6, 7};
		
		System.out.print(findMedianSortedArrays(A, B));
	}
}
