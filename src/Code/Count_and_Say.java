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
        if (n == 1) {
        	return "1";
        }
        
        String compareString = "1";
        StringBuilder sb = new StringBuilder();
        int count = 0;
    	int i = 0;
        int time = 1;
        while (time++ < n) {
        	count = 1;
        	new StringBuilder();
        	for (i = 1; i < compareString.length(); i++) {
        		if (compareString.charAt(i) == compareString.charAt(i - 1)) {
        			count++;
        		} else {
        			sb.append(count).append(compareString.charAt(i - 1));
        			count = 1;
        		}
        	}
        	sb.append(count).append(compareString.charAt(i - 1));
        	compareString = sb.toString();
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int n = 3;
		String result = countAndSay(n);
		System.out.println(result);
	}
}
