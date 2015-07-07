/**
 * 
 * N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *   [".Q..",  // Solution 1
 *    "...Q",
 *    "Q...",
 *    "..Q."],
 *   
 *   ["..Q.",  // Solution 2
 *    "Q...",
 *    "...Q",
 *    ".Q.."]
 * ]
 *          
 */

/*
 * 
 */


import java.util.ArrayList;
import java.util.List;

public class Solution_051_N_Queens {
	public static List<String[]> solveNQueens(int n) {
        List result = new ArrayList();
        if (n == 0) {
        	return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, n);
        return result;
    }
	
	public static void helper(List result, ArrayList<Integer> cols, int n) {
		if (cols.size() == n) {
			String[] temp = drawBoard(cols);
			result.add(temp);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!valid(cols, i)) {
				continue;
			}
			cols.add(i);
			helper(result, cols, n);
			cols.remove(cols.size() - 1);
		}
	}

	private static boolean valid(ArrayList<Integer> cols, int newCol) {
		// TODO Auto-generated method stub
		int newRow = cols.size();
		
		for (int k = 0; k < newRow; k++) {
			int col = cols.get(k);
			if (col == newCol) {
				return false;
			}
			if (k - col == newRow - newCol) {
				return false;
			}
			if (k + col == newRow + newCol) {
				return false;
			}
		}
		return true;
	}

	private static String[] drawBoard(ArrayList<Integer> list) {
		String[] board = new String[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			board[i] = "";
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) == j) {
					board[i] = board[i] + 'Q';
				} else {
					board[i] = board[i] + '.';
				}
			}
		}
		
		return board;
	}
	
	public static void main(String[] args) {
		List<String[]> result = solveNQueens(14);
		
		for (int i = 0; i < result.size(); i++) {
			String[] board = result.get(i);
			for (String s : board) {
				System.out.println(s);
			}
			
			System.out.println();
		}
	}
}
