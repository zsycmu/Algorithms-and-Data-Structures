/**
 * 
 * Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
/*
 * Note:
 */

import java.util.ArrayList;

public class Solution_119_Pascals_Triangle_II {
	public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex == 0) {
        	return result;
        }
        int row = 0;
        while (row < rowIndex) {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
        	for (int i = 1; i < result.size(); i++) {
            	temp.add(result.get(i) + result.get(i - 1));
            }
        	temp.add(1);
        	result = temp;
        	row++;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		System.out.print(getRow(0));
	}
}
