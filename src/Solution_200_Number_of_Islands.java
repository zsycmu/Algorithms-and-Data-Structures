/**
 * 
 * Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 */
/*
 * Note: Please be notice that the result initialized position.
 */

public class Solution_200_Number_of_Islands {
	
	public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
        	return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == '1') {
        			helper(grid, i, j);
        			result++;
        		}
        	}
        }
        
        return result;
    }
	
	public static void helper(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
			return;
		}
		if (grid[x][y] != '1') {
			return;
		}
		grid[x][y] = 'X';
		helper(grid, x - 1, y);
		helper(grid, x, y - 1);
		helper(grid, x + 1, y);
		helper(grid, x, y + 1);
	}
	
	public static void main(String[] args) {
		char[][] input = {{'1', '1', '0', '0', '0'}, 
				  		  {'1', '1', '0', '0', '0'}, 
				  		  {'0', '0', '1', '0', '0'}, 
				  		  {'0', '0', '0', '1', '1'}};
		
		System.out.println(numIslands(input));
	}
}
