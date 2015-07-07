/*
 * Subsets II
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_090_Subsets_II {
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        List result = new ArrayList();
        if (num == null || num.length == 0) {
        	return result;
        }
        
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, num, 0);
        return result;
    }
	
	private static void helper(List result, ArrayList<Integer> list, int[] num, int start) {
		ArrayList<Integer> temp = new ArrayList<Integer>(list);
		result.add(temp);
		
		for (int i = start; i < num.length; i++) {
			if (i != start && num[i] == num[i - 1]) {
				continue;
			}
			list.add(num[i]);
			helper(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		List result = subsetsWithDup(input);
		System.out.print(result);
	}
}
