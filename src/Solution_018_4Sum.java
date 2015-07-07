import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 4Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * lements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 */
/*
 * Notice: 
 */

public class Solution_018_4Sum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List result = new ArrayList();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = num.length - 1;
                while (start < end) {
                    int temp = num[i] + num[j] + num[start] + num[end];
                    if (temp == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
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
                    } else if (temp < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        
        return result;
    }
}
