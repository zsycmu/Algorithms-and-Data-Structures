import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 *
 */
/*
 * Notice: 1. 先start++, end--然后再跳过重复的
 * 		   2. 注意使用while循环
 */

public class Solution_015_3Sum {
	public List<List<Integer>> threeSum(int[] num) {
        List result = new ArrayList();
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int temp = num[i] + num[start] + num[end];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    result.add(list);
                    start++;
                    end--;
                    while (start < end && num[start] == num[start - 1]) {
                        start++;
                    }
                    while (start < end && num[end] == num[end + 1]) {
                        end--;
                    }
                } else if (temp < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return result;
    }
}
