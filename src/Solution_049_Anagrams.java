import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * Anagrams
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 *
 */
/*
 * Notice:
 */

public class Solution_049_Anagrams {
	public List<String> anagrams(String[] strs) {
        List result = new ArrayList();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String s : strs) {
            String str = sortString(s);
            if (!map.containsKey(str)) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(str, temp);
            } else {
                ArrayList<String> temp = map.get(str);
                temp.add(s);
                map.put(str, temp);
            }
        }
        
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                ArrayList<String> temp = map.get(s);
                for (String str : temp) {
                    result.add(str);
                }
            }
        }
        
        return result;
    }
    
    public String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for (char chr : c) {
            sb.append(chr);
        }
        return sb.toString();
    }
}
