import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Permutations
 * 
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */
/*
 * Notice: Should be no problem.
 */

public class Solution_046_Permutations {
	public List<List<Integer>> permute(int[] num) {
        List result = new ArrayList();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, num);
        return result;
    }
    
    public void helper(List result, ArrayList<Integer> list, int[] num) {
        if (num.length == list.size()) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            result.add(temp);
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            helper(result, list, num);
            list.remove(list.size() - 1);
        }
    }
}
