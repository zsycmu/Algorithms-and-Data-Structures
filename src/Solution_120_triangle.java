import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Triangle
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */

/*
 * Note: transfer the triangle to the following format to get better understand.
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 
 * From the bottom to up, use one array to save the temp value.
 * 
 */

public class Solution_120_triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		if (row == 0) {
			return 0;
		}
		
		int[] dp = new int[triangle.get(row - 1).size()];
		int size = triangle.size() - 1;
		
		for (int i = size; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == size) {
					dp[j] = triangle.get(i).get(j);
				} else {
					dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
				}
			}
		}
		
		return dp[0];
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		List input = new ArrayList();
		input.add(list1);
		input.add(list2);
		input.add(list3);
		input.add(list4);
		
		System.out.println(minimumTotal(input));
	}
}
