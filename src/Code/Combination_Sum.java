package Code;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */

public class Combination_Sum {
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		helper(candidates, target, result, temp, 0);
		return result;
    }
	
	private static void helper(int[] candidates, int target, 
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int start) {
		
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				return;
			}
			temp.add(candidates[i]);
			helper(candidates, target - candidates[i], result, temp, i);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {2,3,6,7};
		int target = 4;
		ArrayList<ArrayList<Integer>> result = combinationSum(input, target);
		System.out.print(result);
	}
}
