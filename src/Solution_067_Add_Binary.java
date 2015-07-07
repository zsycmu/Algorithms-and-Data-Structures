/**
 * 
 * Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 */
/*
 * Notice: 注意是大于等于，不是大于。
 */

public class Solution_067_Add_Binary {
	public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        String result = "";
        int carry = 0;
        while (index1 >= 0 || index2 >= 0 || carry > 0) {
            int temp = 0;
            if (index1 >= 0) {
                int num = a.charAt(index1) - '0';
                temp = temp + num;
                index1--;
            }
            if (index2 >= 0) {
                int num = b.charAt(index2) - '0';
                temp = temp + num;
                index2--;
            }
            if (carry > 0) {
                temp = temp + carry;
            }
            result = Integer.toString(temp % 2) + result;
            carry = temp / 2;
        }
        
        return result;
    }
}
