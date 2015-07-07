
/**
 * 
 * Substring with Concatenation of All Words
 * 
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_030_Substring_with_Concatenation_of_All_Words {
	public static List<Integer> findSubstring(String S, String[] L) {
		List result = new ArrayList();
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
        	return null;
        }
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String s : L) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		
		int m = S.length();
		int n = L[0].length();
		int l = L.length;
		
		for (int i = 0; i < m - l * n + 1; i++) {
			HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
			int leftbound = i;
			for (int j = leftbound + n; j < S.length() + 1; j = j + n) {
				String str = S.substring(leftbound, j);
				if (temp.containsKey(str)) {
					if (temp.get(str) == 1) {
						temp.remove(str);
					} else {
						temp.put(str, temp.get(str) - 1);
					}
					if (temp.isEmpty()) {
						result.add(i);
						break;
					}
					leftbound = j;
				} else {
					break;
				}
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		String S = "a";
		String[] L = {"a"};
		List result = findSubstring(S, L);
		System.out.print(result);
	}
}
