/*
 * 
 * Spiral Matrix II
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 *  
 */

public class Solution_059_Spiral_Matrix_II {
	public static int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}
		
		int[][] matrix = new int[n][n];
		
		int num = 1;
		int x = 0;
		int y = 0;
		
		for (int i = n; i > 0; i = i - 2) {
			if (i == 1) {
				matrix[x][y] = num;
			} else {
				for (int j = 0; j < i - 1; j++) {
					matrix[x][y++] = num;
					num++;
				}
				for (int j = 0; j < i - 1; j++) {
					matrix[x++][y] = num;
					num++;
				}
				for (int j = 0; j < i - 1; j++) {
					matrix[x][y--] = num;
					num++;
				}
				for (int j = 0; j < i - 1; j++) {
					matrix[x--][y] = num;
					num++;
				}
				x++;
				y++;
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		int[][] result = generateMatrix(3);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
