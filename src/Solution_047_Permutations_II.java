/**
 * 
 * Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 */
/*
 * Notice: 
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_047_Permutations_II {
	public static List<List<Integer>> permuteUnique(int[] num) {
		List result = new ArrayList();
        if (num == null || num.length == 0) {
        	return result;
        }
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, num, visited);
        
        return result;
    }
	
	public static void helper(List result, ArrayList<Integer> list, int[] num, boolean[] visited) {
		if (list.size() == num.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>(list);
			result.add(temp);
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
			if (visited[i] == true || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == false)){
                continue;
            }
			list.add(num[i]);
			visited[i] = true;
			helper(result, list, num, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] input = {1,1,3};
		System.out.print(permuteUnique(input));
	}
}
