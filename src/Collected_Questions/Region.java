package Collected_Questions;

public class Region {
	
	/*
	 * This is what is known as floodfill, an application of DFS. 
	 * For each element in the array that is a 1 you attempt to recursively 
	 * search all 4 neighbors for 1s, the search continues till you either hit the boundaries or see 0s. 
	 * Also as and when you find 1s you make them 0s so that they are not counted again. Repeat this search for every element 
	 */
	
	public static int countIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		int result = 0;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					result++;
					doFill(matrix, i, j);
				}
			}
		}
		return result;
	}
	public static void doFill(int[][] matrix, int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >=matrix[0].length || matrix[row][col] == 0) {
			return;
		}
		matrix[row][col] = 0;
		doFill(matrix, row + 1, col);
		doFill(matrix, row - 1, col);
		doFill(matrix, row, col + 1);
		doFill(matrix, row, col - 1);
	}
	
	public static void main(String[] args) {
		int m1[][]= {{1,0,0,0},{1,0,0,0},{0,0,0,1}};
		
		System.out.println(countIslands(m1));
		
		int m2[][]= {{1,1,1,1},{0,0,0,0},{1,0,0,1}};
		
		System.out.println(countIslands(m2));
		
		int m3[][]= {{1,0,1,1},{0,1,0,0},{0,0,1,1},{1,1,0,1}};
		
		System.out.println(countIslands(m3));
		
	}

}