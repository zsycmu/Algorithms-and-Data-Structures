/**
 * 
 * Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 */
/*
 * Notice: 1. This is for a better solution.:http://www.cnblogs.com/avril/archive/2013/08/24/3278873.html
 * 		   2. http://blog.csdn.net/doc_sgl/article/details/11805519
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_084_Largest_Rectangle_in_Histogram {

	public static int largestRectangleArea(List<Integer> height) {
		if (height == null || height.size() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int area = 0;
		int i = 0;
		while (i < height.size()) {
			if (stack.isEmpty() || height.get(stack.peek()) <= height.get(i)) {
				stack.push(i);
				i++;
			} else {
				int index = stack.peek();
				stack.pop();
				area = Math.max(area, height.get(index) * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
			}
		}

		return area;
	}

	public static int largestRectangleArea1(List<Integer> height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (height == null || height.size() == 0) {
			return 0;
		}
		int area = 0;
		for (int i = 0; i < height.size(); i++) {
			for (int k = i + 1; k < height.size(); k++) {
				if (height.get(k) < height.get(k - 1)) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}

			int low = height.get(i);
			for (int j = i; j >= 0; j--) {
				if (height.get(j) < low) {
					low = height.get(j);
				}

				int temparea = (i - j + 1) * low;
				if (temparea > area) {
					area = temparea;
				}
			}
		}

		return area;
	}

	public static int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int result = 0;
        
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
                i++;
            } else {
                int temp = stack.peek();
                stack.pop();
                result = Math.max(result, height[i] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		List input = new ArrayList();
		input.add(2);
		input.add(1);
		input.add(5);
		input.add(6);
		input.add(2);
		input.add(3);
		int[] input2 = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea2(input2));
	}
}
