/**
 * 
 * Multiply Strings
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */
/*
 * Notice: 1. i和j的循环是从后向前的
 * 		   2. 最后算carry的时候是（result[i] + carry) / 10
 * 		   3. 跳过前面是0的部分
 */
public class Solution_043_Multiply_String {
	public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null; 
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] num3 = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                num3[i + j + 1] = num3[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        int carry = 0;
        for (int i = num3.length - 1; i >= 0; i--) {
            int temp = carry + num3[i];
            carry = temp / 10;
            num3[i] = temp % 10;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while (num3[i] == 0 && i < num3.length - 1) {
            i++;
        }
        for (; i < num3.length; i++) {
            sb.append(num3[i]);
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s1 = "12";
		String s2 = "12";
		
		String result = multiply(s1, s2);
		
		System.out.println(result);
	}
}
