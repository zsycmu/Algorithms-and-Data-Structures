import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Combination Sum
 * 
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
 *
 */
/*
 * Notice: if target < 0; continue;
 */

public class Solution_039_Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List result = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, candidates, list, target, 0);
        
        return result;
    }
    
    public void helper(List result, int[] candidates, ArrayList<Integer> list, int target, int start) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            result.add(temp);
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (target < 0) {
                continue;
            }
            list.add(candidates[i]);
            helper(result, candidates, list, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
