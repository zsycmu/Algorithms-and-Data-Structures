/**
 * 
 * Reverse Bits
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * 
 */


/*
 * Note:
 * If this function is called many times, how would you optimize it?
 * http://www.bubuko.com/infodetail-661564.html
 * 
 */

public class Solution_190_Reverse_Bits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                res = (res << 1) + 1;
                n = n >> 1;
            } else {
                res = res << 1;
                n = (n >> 1);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int n = 8;
    	System.out.print(reverseBits(n));
    }
}
