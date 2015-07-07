import java.util.HashSet;

/**
 * 
 * Valid Sudoku
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 */
/*
 * Notice: Take care of the '.'. Not all of the character is number.
 */

public class Solution_036_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        HashSet<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < m; i++) {
            set = new HashSet<Character>();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            set = new HashSet<Character>();
            for (int j = 0; j < n; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        
        for (int i = 0; i < m; i = i + 3) {
            for (int j = 0; j < n; j = j + 3) {
                set = new HashSet<Character>();
                for (int k = 0; k < 9 ;k++) {
                    char c = board[i + k / 3][j + k % 3];
                    if (c == '.') {
                        continue;
                    }
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        
        return true;
    }
}
