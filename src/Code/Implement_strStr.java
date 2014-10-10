package Code;
/*
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

public class Implement_strStr {
	public static String strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
        	return null;
        }
        
        int j;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
        	for (j = 0; j < needle.length(); j++) {
        		if (haystack.charAt(i + j) != needle.charAt(j)) {
        			break;
        		}
        	}
        	if (j == needle.length()) {
    			return haystack.substring(i);
    		}
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		String haystack = "abcdefg";
		String needle = "cd";
		String result = strStr(haystack, needle);
		System.out.print(result);
	}
}
