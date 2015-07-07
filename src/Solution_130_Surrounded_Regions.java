/**
 * 
 * Surrounded Regions
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 */
/*
 * Notice: 1. not only up roll and left col. Also should take care of the right col and down roll.
 * 		   2. DFS will take too much time. Use BFS instead.
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution_130_Surrounded_Regions {
	public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
        	return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][0] == 'O') {
        			BFS(board, i, 0);
        		}
        		if (board[0][j] == 'O') {
        			BFS(board, 0, j);
        		}
        		if (board[i][n - 1] == 'O') {
        			BFS(board, i, n - 1);
        		}
        		if (board[m - 1][j] == 'O') {
        			BFS(board, m - 1, j);
        		}
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == 'P') {
        			board[i][j] = 'O';
        		}
        	}
        }
    }
	
	public static void DFS(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
			return;
		}
		
		if (board[i][j] == 'O') {
			board[i][j] = 'P';
			DFS(board, i - 1, j);
			DFS(board, i, j - 1);
			DFS(board, i + 1, j);
			DFS(board, i, j + 1);
		}
	}
	
	public static void BFS(char[][] board, int i, int j) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		
		Point thisPoint = new Point(i, j);
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(thisPoint);
		
		board[i][j] = 'P';
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				Point temp = queue.poll();
				int x = temp.x;
				int y = temp.y;
				
				if (x != 0 && board[x - 1][y] == 'O') {
					queue.add(new Point(x - 1, y));
					board[x - 1][y] = 'P';
				}
				
				if (y != 0 && board[x][y - 1] == 'O') {
					queue.add(new Point(x, y - 1));
					board[x][y - 1] = 'P';
				}
				if (x != board.length - 1 && board[x + 1][y] == 'O') {
					queue.add(new Point(x + 1, y));
					board[x + 1][y] = 'P';
				}
				if (y != board[0].length - 1 && board[x][y + 1] == 'O') {
					queue.add(new Point(x, y + 1));
					board[x][y + 1] = 'P';
				}
			}
		}
	}
	
	public static void main(String[] args) {
		char[][] input = {
						  {'X', 'X', 'X', 'X'}, 
						  {'X', 'O', 'O', 'X'}, 
						  {'X', 'X', 'O', 'X'}, 
						  {'X', 'O', 'X', 'X'}
						  };
		solve(input);
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}
