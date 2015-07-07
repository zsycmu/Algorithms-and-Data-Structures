/*
 * Gray Code Total Accepted: 30786 Total Submissions: 94542 My Submissions Question Solution 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_089_Gray_Code {
	public static List<Integer> grayCode(int n) {
        if (n == 0) {
        	List result = new ArrayList<Integer>();
        	result.add(0);
        	return result;
        }
        
        List<Integer> temp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        List result = new ArrayList<Integer>(temp);
        
        for (int i = temp.size() - 1; i >= 0; i--) {
        	result.add(addNumber + temp.get(i));
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		List<Integer> result = grayCode(2);
		System.out.print(result);
	}
}
