package Collected_Questions;

public class NearestNumber {
	public static Integer getMaxerNumber(int[] input, int target) {
		if (input == null || input.length == 0) {
			return null;
		}
		
		int start = 0;
		int end = input.length - 1;
		int mid;
		
		while (start + 1 < end) {
			mid = (start + end) / 2;
			if (input[mid] == target) {
				return input[mid + 1];
			} else if (input[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (input[start] == target) {
			return input[start + 1];
		}
		
		if (input[end] == target) {
			return null;
		}
		
		return input[start + 1];
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,5,6,7};
		int target = 10;
		
		System.out.println(getMaxerNumber(input, target));
		
	}
}
