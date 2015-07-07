import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 *
 */
/*
 * 
 */
public class Solution_131_Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
        List result = new ArrayList();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        ArrayList<String> list = new ArrayList<String>();
        helper(result, list, s, 0);
        
        return result;
    }
    
    public void helper(List result, ArrayList<String> list, String s, int start) {
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(list);
            result.add(temp);
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                list.add(str);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
