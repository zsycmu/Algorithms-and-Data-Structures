/**
 * 
 * Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 *
 */
/*
 * Notice: 1. 注意k大约nums长度的情况。
 * 		   2. 真正做题的时候要画个图。
 */

public class Solution_189_Rotate_Array {
	public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (k > nums.length - 1) {
            k = k % nums.length;
        }
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }
    
    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
