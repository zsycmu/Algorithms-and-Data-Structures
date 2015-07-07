/**
 * 
 * Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * A sudoku puzzle...
 * ...and its solution numbers marked in red.
 * 
 */

/*
 * Note: where to put the new HashSet<Character> part. Be careful for where to put the return false statements.
 */

import java.util.HashSet;

public class Solution_037_Sudoku_Solver {
	public static void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		
		helper(board);
	}
	
	public static boolean helper(char[][] board) {
		if (board == null || board.length == 0) {
			return false;
		}
		
		int m = board.length;
		int n = board[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						board[i][j] = c;
						if (valid(board) && helper(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean valid(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		HashSet<Character> set = null;
        
		for (int i = 0; i < 9; i++) {
			set = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (matrix[i][j] == '.') {
					continue;
				}
				if (set.contains(matrix[i][j])) {
					return false;
				} else {
					set.add(matrix[i][j]);
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			set = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (matrix[j][i] == '.') {
					continue;
				}
				if (set.contains(matrix[j][i])) {
					return false;
				} else {
					set.add(matrix[j][i]);
				}
			}
		}
		
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				set = new HashSet<Character>();
				for (int k = 0; k < 9; k++) {
					if (matrix[i + k/ 3][j + k % 3] == '.') {
						continue;
					}
					if (set.contains(matrix[i + k/ 3][j + k % 3])) {
						return false;
					} else {
						set.add(matrix[i + k/ 3][j + k % 3]);
					}
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
						   {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, 
						   {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
						   {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, 
						   {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, 
						   {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, 
						   {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, 
						   {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, 
						   {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
