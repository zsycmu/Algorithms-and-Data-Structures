package persist;

import java.util.ArrayList;

/**
 * Permutation Sequence
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 */

/*
 * Note:
 */
1
public class Solution_060_ {
	public static String getPermutation(int n, int k) {
		ArrayList<String> list = new ArrayList<String>();
        if (n == 0) {
        	return null;
        }
        
        StringBuilder sb = new StringBuilder();
        helper(list, sb, n);
        return list.get(k - 1);
    }
	
	public static void helper(ArrayList<String> list, StringBuilder sb, int n) {
		if (sb.length() == n) {
			String str = sb.toString();
			list.add(str);
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!sb.toString().contains(Integer.toString(i))) {
				sb.append(i);
				helper(list, sb, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		System.out.print(getPermutation(n, k));
	}
}
