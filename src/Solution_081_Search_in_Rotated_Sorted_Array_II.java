/*
 * 
 * Search in Rotated Sorted Array II
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 */
public class Solution_081_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] A, int target) {
        if (A == null) {
            return false;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        
        return false;
    }
}
