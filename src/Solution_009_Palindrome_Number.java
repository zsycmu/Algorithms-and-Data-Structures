/**
 * 
 * Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * click to show spoilers. Some hints: Could negative integers be palindromes?
 * (ie, -1) If you are thinking of converting the integer to string, note the
 * restriction of using extra space. You could also try reversing an integer.
 * However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case? There is a
 * more generic way of solving this problem.
 *
 */
/*
 * Notice: if x < 0; return false;
 */
public class Solution_009_Palindrome_Number {
	public boolean isPalindrome(int x) {
		if (x == 0) {
			return true;
		}
		if (x < 0) {
			return false;
		}
		int temp = x;
		long reverse = 0;

		while (temp != 0) {
			reverse = reverse * 10 + temp % 10;
			temp = temp / 10;
		}

		if (reverse == x) {
			return true;
		} else {
			return false;
		}
	}
}
