/*
 * Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 */

public class Solution_048_Rotate_Image {
	public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, m - 1 - j);
            }
        }
    }
    
    public static void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = 0;
        temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
    
    public static void main(String[] args) {
    	int[][] input = {{1, 2}, {3, 4}};
    	rotate(input);
    	for (int i = 0; i < input.length; i++) {
    		for (int j = 0; j < input[0].length; j++) {
    			System.out.print(input[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
