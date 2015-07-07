/**
 * 
 * Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 */
/*
 * 
 */

import java.util.HashMap;

public class Solution_076_Minimum_Window_Substring {
	public static String minWindow(String S, String T) {
		if (S == null || T == null) {
			return null;
		}
		
		HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
		
		for (int i = 0; i < T.length(); i++) {
			if (!toFind.containsKey(T.charAt(i))) {
				toFind.put(T.charAt(i), 1);
			} else {
				toFind.put(T.charAt(i), toFind.get(T.charAt(i)) + 1);
			}
		}
		
		HashMap<Character, Integer> find = new HashMap<Character, Integer>();
		int size = 0;
		int leftbound = 0;
		String result = null;
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			if (!toFind.containsKey(c)) {
				continue;
			}
			
			if (!find.containsKey(S.charAt(i))) {
				find.put(S.charAt(i), 1);
			} else {
				find.put(S.charAt(i), find.get(S.charAt(i)) + 1);
			}
			
			if (find.get(S.charAt(i)) <= toFind.get(S.charAt(i))) {
				size++;
			}
			
			if (size == T.length()) {
				
				while (leftbound < S.length()) {
					if (!toFind.containsKey(S.charAt(leftbound))) {
						leftbound++;
						continue;
					}
					if (find.get(S.charAt(leftbound)) > toFind.get(S.charAt(leftbound))) {
						find.put(S.charAt(leftbound), find.get(S.charAt(leftbound)) - 1);
						leftbound++;
						continue;
					}
					break;
					
				}
				if (result == null || i - leftbound + 1 < result.length()) {
					result = S.substring(leftbound, i + 1);
				}
			}
		}
		if (result == null) {
			return "";
		}
		return result;
	}
	
	public static void main(String[] args) {
		String S = "acbbaca";
		String T = "aba";
		
//		"acbbaca", "aba"
//		Output:	"acbba"
//		Expected:	"baca"

		
		System.out.print(minWindow(S, T));
	}
}
