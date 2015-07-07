import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find Peak Element 
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * click to show spoilers.
 * Note:
 * Your solution should be in logarithmic complexity.
 *
 */

/*
 * Note: if the input array is an increasing array or decreasing array, 
 * we should compare the num[start] and num[end] and return the bigger one.
 * 
 */

public class Solution_162_Find_Peak_Element {
	public static int findPeakElement(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.size() - 1;
        int mid = 0;
        
        while (start + 1 < end) {
            mid = (end - start) / 2 + start;
            if (nums.get(mid - 1) < nums.get(mid) && nums.get(mid + 1) < nums.get(mid)) {
                return mid;
            } else if (nums.get(start) < nums.get(mid) && nums.get(mid) < nums.get(mid + 1)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums.get(start) > nums.get(end)) {
            return start;
        } else {
            return end;
        }
    }
	
	public static int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
        	return -1;
        }
        
        int start = 0;
        int end = num.length - 1;
        int mid = 0;
        
        while (start + 1 < end) {
        	mid = (end - start) / 2 + start;
        	if (num[mid - 1] < num[mid] && num[mid + 1] < num[mid]) {
        		return mid;
        	} else if (num[start] < num[mid] && num[mid + 1] > num[mid]) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        
        if (num[start] > num[end]) {
            return start;
        } else {
            return end;
        }
    }
	
	public static void main(String[] args) {
//		int[] input = {1, 2};
//		System.out.println(findPeakElement(input));
//		
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(1);
		input2.add(2);
		
		System.out.println(findPeakElement(input2));
	}
}
