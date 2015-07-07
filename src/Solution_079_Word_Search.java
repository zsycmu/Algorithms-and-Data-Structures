/**
 * 
 * Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 */
/*
 * Notice:
 */
public class Solution_079_Word_Search {
	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, i, j, word.substring(1))) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, String s) {
        if (s.length() == 0) {
            return true;
        }
        if (board[i][j] == '.') {
            return false;
        }
        
        if (i != 0 && board[i - 1][j] == s.charAt(0)) {
            char c = board[i][j];
            board[i][j] = '.';
            if (helper(board, i - 1, j, s.substring(1))) {
                return true;
            }
            board[i][j] = c;
        }
        
        if (j != 0 && board[i][j - 1] == s.charAt(0)) {
            char c = board[i][j];
            board[i][j] = '.';
            if (helper(board, i, j - 1, s.substring(1))) {
                return true;
            }
            board[i][j] = c;
        }
        
        if (i != board.length - 1 && board[i + 1][j] == s.charAt(0)) {
            char c = board[i][j];
            board[i][j] = '.';
            if (helper(board, i + 1, j, s.substring(1))) {
                return true;
            }
            board[i][j] = c;
        }
        
        if (j != board[0].length - 1 && board[i][j + 1] == s.charAt(0)) {
            char c = board[i][j];
            board[i][j] = '.';
            if (helper(board, i, j + 1, s.substring(1))) {
                return true;
            }
            board[i][j] = c;
        }
        
        return false;
    }
}
