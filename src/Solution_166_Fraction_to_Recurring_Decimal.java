import java.util.HashMap;

/**
 * 
 * Fraction to Recurring Decimal
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */

/*
 * This is remembtered.
 * Note: 
 * http://blog.csdn.net/ljiabin/article/details/42025037
 */
public class Solution_166_Fraction_to_Recurring_Decimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
        	return "0";
        }
        if (denominator == 0) {
        	return "";
        }
        
        String result = "";
        
        if (numerator < 0 || denominator < 0) {
        	result = result + "-";
        }
        
        long num = numerator;
        long den = denominator;
        
        num = Math.abs(num);
        den = Math.abs(den);
        
        long res = num / den;
        result = result + String.valueOf(res);
        
        long rem = (num % den) * 10;
        if (rem == 0) {
        	return result;
        }
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result = result + ".";
        
        while (rem != 0) {
        	if (map.containsKey(rem)) {
        		int begin = map.get(rem);
        		String part1 = result.substring(0, begin);
        		String part2 = result.substring(begin, result.length());
        		result = part1 + "(" + part2 + ")";
        		return result;
        	}
        	map.put(rem, result.length());
        	res = rem / den;
        	result = result + String.valueOf(res);
        	rem = (rem % den) * 10;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String result = fractionToDecimal(2, 3);
		System.out.println(result);
	}
}
