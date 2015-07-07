/**
 * 
 * Compare Version Numbers
 * 
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 */

/*
 * Note: http://www.cnblogs.com/easonliu/p/4218557.html
 */

public class Solution_165_Compare_Version_Numbers {
	public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
        	return 0;
        }
        
        int index1 = 0;
        int index2 = 0;
        int version_1 = 0;
        int version_2 = 0;
        
        while (index1 < version1.length() || index2 < version2.length()) {
        	version_1 = 0;
        	while (index1 < version1.length()) {
        		if (version1.charAt(index1) == '.') {
        			index1++;
        			break;
        		}
        		
        		version_1 = version_1 * 10 + (version1.charAt(index1) - '0');
        		index1++;
        	}
        	
        	version_2 = 0;
        	while (index2 < version2.length()) {
        		if (version2.charAt(index2) == '.') {
        			index2++;
        			break;
        		}
        		
        		version_2 = version_2 * 10 + (version2.charAt(index2) - '0');
        		index2++;
        	}
        	
        	if (version_1 > version_2) {
        		return 1;
        	} else if (version_1 < version_2) {
        		return -1;
        	}
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		String version1 = "1";
		String version2 = "0.1";
		
		System.out.print(compareVersion(version1, version2));
	}
}
