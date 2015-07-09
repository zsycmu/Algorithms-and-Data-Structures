package Collected_Questions;

public class NextPermutation {
	public static void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        
        int first = 0;
        int second = 0;
        
        for (int i = num.length - 1; i >= 1; i--) {
            if (num[i] > num[i - 1]) {
                first = i - 1;
                break;
            }
        }
        
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] > num[first]) {
                second = i;
                break;
            }
        }
        
        swap(num, first, second);
        reverse(num, first + 1, num.length - 1);
    }
    
    public static void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public static void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
    	int[] input = {3, 2, 1};
    	nextPermutation(input);
    	for (int i = 0; i < input.length; i++) {
    		System.out.println(input[i]);
    	}
    }
}
