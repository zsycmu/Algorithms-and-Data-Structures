/**
 * 
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 */
public class Solution_064_Minimum_Path_Sum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] dp = grid;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i - 1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
