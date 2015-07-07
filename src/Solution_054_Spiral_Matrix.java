/**
 * 
 * Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 */
/*
 * Notice: 1. while循环的地方是与的关系，不是或。
 * 		   2. 等于1时候的情况。
 * 		   3. 每次只便利一行或一列长度减一的地方。
 */
import java.util.ArrayList;

public class Solution_054_Spiral_Matrix {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = 0;
		
		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				//Must break here. Already in the most inner layer.
				break;
			}
			if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}
			//Here notice here n or m should be located.
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}
			//Here is important, if not plus one, it will run to the outer layer.
			x++; 
			y++;
			m = m - 2;
			n = n - 2;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, 
						  {5,6,7,8}, 
						  {9,10,11,12},
						  {13, 14, 15,16}};
//		int[][] matrix2 = {{1,2,3},
//						   {4,5,6},
//						   {7,8,9}};
//		int[][] matrix3 = {{1,2,3},
//				   		   {4,5,6}};
//		int[][] matrix4 = {{3},{6}};
		ArrayList<Integer> result = spiralOrder(matrix);
		System.out.print(result);
	}
}
