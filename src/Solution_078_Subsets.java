import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Subsets
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
/*
 * Notice: 
 */

public class Solution_078_Subsets {
	public List<List<Integer>> subsets(int[] S) {
        List result = new ArrayList();
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, S, 0);
        return result;
    }
    
    public void helper(List result, ArrayList<Integer> list, int[] S, int start) {
        ArrayList<Integer> temp = new ArrayList<Integer>(list);
        result.add(temp);
        
        for (int i = start; i < S.length; i++) {
            list.add(S[i]);
            helper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
