import java.util.Arrays;

/**
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *  
 */
/*
 * Notice: 1. 分析好题再动笔。
 * 		   2. time complexity: O(n).
 */
public class Solution_016_3Sum_Closest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
            return 0;
        }
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        
        for (int i = 0; i < num.length; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                int diff = Math.abs(sum - target);
                int diff_first = Math.abs(result - target);
                if (diff < diff_first) {
                    result = sum;
                } else if (sum == target) {
                    return target;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return result;
    }
}
