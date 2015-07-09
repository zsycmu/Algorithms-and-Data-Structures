package Collected_Questions;

public class Nearest {
	//http://www.careercup.com/question?id=4716965625069568
	public static void dfs(int[][] matrix, int x, int y, int step){
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) return;
		if (matrix[x][y] < 0) return;
		if (matrix[x][y]>step + 1 || matrix[x][y] == 0) 
			matrix[x][y] = step + 1;
		else return;
		dfs(matrix, x + 1, y, step + 1);
		dfs(matrix, x, y + 1, step + 1);
		dfs(matrix, x - 1, y, step + 1);
		dfs(matrix, x, y - 1, step + 1);
	}

	public static void RoomGuard(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == -1){
					dfs(matrix, i-1, j, 0);
					dfs(matrix, i, j-1, 0);
					dfs(matrix, i +1, j, 0);
					dfs(matrix, i , j+1, 0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,0,0, 0}, {-1,0,0, -1}, {0,0,0, 0}, {0,0,0, 0}};
		RoomGuard(matrix);
		System.out.println("finish");
	}
}