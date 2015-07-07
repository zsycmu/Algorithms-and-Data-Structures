/**
 * 
 * N-Queens II
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 */
/*
 * Notice: 
 */


import java.util.ArrayList;

public class Solution_052_N_Queens_II {
	public static int result;
	public static int totalNQueens(int n) {
        if (n == 0) {
        	return 0;
        }
        result = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, n);
        return result;
    }
	
	public static void helper(ArrayList<Integer> list, int n) {
		if (list.size() == n) {
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!valid(list, i)) {
				continue;
			}
			list.add(i);
			helper(list, n);
			list.remove(list.size() - 1);
		}
	}

	private static boolean valid(ArrayList<Integer> list, int newCol) {
		int newRow = list.size();
		for (int oldRow = 0; oldRow < list.size(); oldRow++) {
			int oldCol = list.get(oldRow);
			if (newCol == oldCol) {
				return false;
			}
			if (oldRow - oldCol == newRow - newCol) {
				return false;
			}
			if (oldRow + oldCol == newRow + newCol) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.print(totalNQueens(2));
	}
}
