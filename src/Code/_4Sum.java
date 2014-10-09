package Code;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 *  (-1,  0, 0, 1)
 *  (-2, -1, 1, 2)
 *  (-2,  0, 0, 2)
 */

public class _4Sum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0 || num.length < 4) {
    		return result;
    	}
    	
    	Arrays.sort(num);
    	
    	
    	for (int i = 0; i < num.length - 3; i++) {
    		if (i != 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		for (int j = 1; j < num.length - 2; j++) {
    			if (j != 1 && num[j] == num[j - 1]) {
        			continue;
        		}
    			
    			//Must j + 1, start not always from 2.
    			int start = j + 1;
    	    	int end = num.length - 1;
    			while (start < end) {
    				int temp = num[i] + num[j] + num[start] + num[end];
        			if (temp == target) {
        				ArrayList<Integer> tempList = new ArrayList<Integer>();
        				tempList.add(num[i]);
        				tempList.add(num[j]);
        				tempList.add(num[start]);
        				tempList.add(num[end]);
        				result.add(tempList);
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
    
    public static void main(String[] args) {
    	int[] num = {1, 0, -1, 0, -2, 2};
    	int target = 0;
    	ArrayList<ArrayList<Integer>> result = fourSum(num, target);
    	System.out.println(result);
    }
}