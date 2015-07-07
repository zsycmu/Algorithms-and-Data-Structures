/**
 * 
 * Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 */
/*
 * Notice:
 */
public class Solution_053_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        
        return max;
    }
}
