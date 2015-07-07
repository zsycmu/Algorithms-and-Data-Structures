/**
 * 
 * Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 */
/*
 * Notice: 最后else的地方，表示最后一个都小于target，那就插到最后一个地方加一的地方。
 */

public class Solution_035_Search_Insert_Position {
	public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        
        while (start + 1 < end) {
            mid = (end - start) / 2 + start;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
