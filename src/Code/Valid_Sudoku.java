package Code;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Valid_Sudoku {
	public static boolean isValidSudoku(char[][] board) {
		int m = board.length;
		int n = board[0].length;
        if (board == null || m == 0 || n == 0) {
        	return false;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < m; i++) {
        	set = new HashSet<Character>();
        	for (int j = 0; j < n; j++) {
        		if (set.contains(board[i][j]) && board[i][j] != '.') {
            		return false;
            	} else {
            		set.add(board[i][j]);
            	}
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	set = new HashSet<Character>();
        	for (int j = 0; j < n; j++) {
        		if (set.contains(board[j][i]) && board[i][j] != '.') {
            		return false;
            	} else {
            		set.add(board[j][i]);
            	}
        	}
        }
        
        for (int i = 0; i < m; i = i + 3) {
        	set = new HashSet<Character>();
        	for (int j = 0; j < n; j = j + 3) {
    		    for (int k = 0; k<9; k++) {
                    if (set.contains(board[i + k/3][ j + k%3]) && board[i + k/3][ j + k%3] != '.') {
                        return false;
                    }
                }
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		char[][] input = {
				{'.', '.', '5', '.', '.', '.', '.', '.', '6'},
				{'.', '.', '.', '.', '1', '4', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '9', '2', '.', '.'},
				{'5', '.', '.', '.', '.', '2', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '3', '.'},
				{'.', '.', '.', '5', '4', '.', '.', '.', '.'},
				{'3', '.', '.', '.', '.', '.', '4', '2', '.'},
				{'.', '.', '.', '2', '7', '.', '6', '.', '.'}};
		
		System.out.print(isValidSudoku(input));
	}
}
