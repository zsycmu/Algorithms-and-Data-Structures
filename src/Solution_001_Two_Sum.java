import java.util.HashMap;

/**
 * 
 * Two Sum
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */
/*
 * Notice: result初始化的时候要用new，然后分别赋值，否则会超时。
 * 
 * Time: O(n), Space: O(n)
 * 
 */

public class Solution_001_Two_Sum {
	public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (!map.containsKey(temp)) {
                map.put(numbers[i], i);
            } else {
                result[0] = map.get(temp) + 1;
                result[1] = i + 1;
                return result;
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		int[] result = twoSum(input, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
}
