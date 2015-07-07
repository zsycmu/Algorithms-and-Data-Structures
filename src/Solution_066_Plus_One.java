/**
 * 
 * Plus One
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */
/*
 * Notice: 最后一位应该分别处理。
 */

public class Solution_066_Plus_One {
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int len = digits.length;
        
        if (digits[len - 1] != 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        }
        
        digits[len - 1] = 0;
        int carry = 1;
        
        for (int i = len - 2; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] newResult  = new int[len + 1];
            newResult[0] = 1;
            for (int i = 1; i < newResult.length; i++) {
                newResult[i] = digits[i - 1];
            }
            return newResult;
        }
    }
}
