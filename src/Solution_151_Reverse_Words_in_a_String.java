/**
 * 
 * Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * 
 */

/*
 * Note: If the input is null or the length is 0. Return "".
 */

public class Solution_151_Reverse_Words_in_a_String {
	public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = split.length - 1; i >= 0; i--) {
        	String temp = split[i].trim();
        	if (temp != null && temp.length() != 0) {
        		sb.append(temp);
        		sb.append(" ");
        	}
        }
        
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		String input = "the sky is blue";
		String result = reverseWords(input);
		System.out.println(result);
	}
}
