package Code;

import java.util.ArrayList;
/*
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of 
 * each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
import java.util.HashMap;

public class Substring_with_Concatenation_of_All_Words {
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (S == null || S.length() == 0) {
        	return result;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> find = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
        	if (map.containsKey(L[i])) {
        		map.put(L[i], map.get(L[i] + 1));
        	} else {
        		map.put(L[i], 1);
        	}
        }
        
        for (int i = 0; i < S.length() - L[0].length() * L.length + 1; i++) {
        	find.clear();
        	int j = 0;
        	
        	for (j = 0; j < L.length; j++) {
        		int k = i + j * L[0].length();
        		String tempString = S.substring(k, k + L[j].length());
            	if (!map.containsKey(tempString)) {
            		break;
            	}
            	if (!find.containsKey(tempString)) {
            		find.put(tempString, 1);
            	} else {
            		find.put(tempString, find.get(tempString) + 1);
            	}
            	if (find.get(tempString) > map.get(tempString)) {
            		break;
            	}
        	}
        	
        	if (j == L.length) {
        		result.add(i);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		
		System.out.print(findSubstring(S, L));
	}
}
