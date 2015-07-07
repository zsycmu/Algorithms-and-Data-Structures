/**
 * 
 * Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 */

/*
 * note: For the condition to add list to result, besides the list size should be 4, 
 * the start position should be the size of the input string. And for the input size, it cannot be shorter than 4 or longer than 12.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_093_Restore_IP_Addresses {
	public static List<String> restoreIpAddresses(String s) {
		List result = new ArrayList();
		if(s.length() <4 || s.length() > 12) {
			return result;
		}
        if (s == null || s.length() == 0) {
        	return result;
        }
        ArrayList<String> list = new ArrayList<String>();
        helper(result, list, s, 0);
        return result;
    }
	
	public static void helper(List result, ArrayList<String> list, String s, int start) {
		if (list.size() == 4 && s.length() == start) {
			StringBuilder sb = new StringBuilder();
			for (String str : list) {
				sb.append(str);
				sb.append(".");
			}
			
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
			return;
		}
		
		for (int i = start; i < s.length() && i <= start + 3; i++) {
			String temp = s.substring(start, i + 1);
			if (isValid(temp)) {
				list.add(temp);
				helper(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}
		int i = Integer.parseInt(s);
		return i <= 255 && i >= 0;
	}
	
	public static void main(String[] args) {
		String input = "25525511135";
		System.out.print(restoreIpAddresses(input));
	}
}
