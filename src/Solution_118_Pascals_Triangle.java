import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
/*
 * Notice: 
 */
public class Solution_118_Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
        List result = new ArrayList();
        if (numRows == 0) {
            return result;
        }
        
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        
        for (int j = 2; j <= numRows; j++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int i = 1; i < pre.size(); i++) {
                int temp = pre.get(i - 1) + pre.get(i);
                cur.add(temp);
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }
        
        return result;
    }
}
