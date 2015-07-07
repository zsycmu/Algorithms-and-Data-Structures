/**
 * 
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 */

/*
 * Note: Should remove the number to save time. This is very important. 
 */

import java.util.HashSet;

public class Solution_128_Longest_Consecutive_Sequence {
	public static int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (Integer i : num) {
            set.add(i);
        }
        
        int max = 0;
        
        for (Integer i : num) {
            int count = 1;
            int temp = i;
            while (true) {
                if (set.contains(temp - 1)) {
                	set.remove(temp - 1);
                	count++;
                    temp--;
                } else {
                    break;
                }
            }
            temp = i;
            while (true) {
                if (set.contains(temp + 1)) {
                	set.remove(temp + 1);
                	count++;
                    temp++;
                } else {
                    break;
                }
            }
            max = Math.max(count, max);
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		int[] input = {100, 4, 200, 1, 3, 2};
		System.out.print(longestConsecutive(input));
	}
}
