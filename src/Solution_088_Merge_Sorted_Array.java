/**
 * 
 * Merge Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 *
 */
/*
 * Notice:
 */
public class Solution_088_Merge_Sorted_Array {
	public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            return;
        }
        
        int index = A.length - 1;
        
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                m--;
            } else {
                A[index] = B[n - 1];
                n--;
            }
            index--;
        }
        
        while (m > 0) {
            A[index] = A[m - 1];
            m--;
            index--;
        }
        
        while (n > 0) {
            A[index] = B[n - 1];
            n--;
            index--;
        }
    }
}
