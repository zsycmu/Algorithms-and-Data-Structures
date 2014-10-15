package Code;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */

public class Count_and_Say {
	public static String countAndSay(int n) {
        if (n == 0) {
        	return null;
        }
        
        String compareString = "1";
        String result = "";
        
        while (n > 0) {
        	int count = 1;
        	int index = 0;
        	int i;
        	for (i = 0; i < compareString.length(); i++) {
        		if (i == 0 || compareString.charAt(i) != compareString.charAt(i - 1)) {
        			result = result + count + compareString.charAt(i);
        			compareString = result;
        			count = 1;
        		} else {
        			count++;
        		}
        	}
        	n--;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int n = 3;
		String result = countAndSay(n);
		System.out.println(result);
	}
}
