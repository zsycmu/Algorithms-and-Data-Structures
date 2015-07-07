import java.util.ArrayList;
import java.util.List;

/*
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * 
 */
public class Solution_077_Combinations {
	public static List<List<Integer>> combine(int n, int k) {
        List result = new ArrayList();
        if (n == 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, n, k, 1);
        return result;
    }
    
    public static void helper(List result, ArrayList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            result.add(temp);
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	List result = combine(4, 2);
    	System.out.println(result);
    }
}
