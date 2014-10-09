package Code;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */

public class Combination_Sum_II {
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(num, target, result, list, 0);
		return result;
    }
	
	private static void helper(int[] num, int target, ArrayList<ArrayList<Integer>> result, 
			ArrayList<Integer> list, int start) {
		
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(list);
			result.add(temp);
			return;
		}

		for (int i = start; i < num.length; i++) {
			if (target - num[i] < 0) {
				return;
			}
			if (i != start && num[i] == num[i - 1]) {
				continue;
			}
			list.add(num[i]);
			helper(num, target - num[i], result, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {10,1,2,7,6,1,5};
		int target = 8;
		ArrayList<ArrayList<Integer>> result = combinationSum2(input, target);
		System.out.print(result);
	}
}
