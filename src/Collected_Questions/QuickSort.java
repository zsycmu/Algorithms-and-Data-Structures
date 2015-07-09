package Collected_Questions;

public class QuickSort {
	//http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
	public void sort(int[] input) {
		if (input == null || input.length == 0) {
			return;
		}
		
		quickSort(input, 0, input.length - 1);
	}
	
	public void quickSort(int[] input, int start, int end) {
		int pivot = start + (end - start) / 2;
		int i = start;
		int j = end;
		
		while (i <= j) {
			
			while (input[i] < input[pivot]) {
				i++;
			}
			while (input[j] > input[pivot]) {
				j--;
			}
			if (i <= j) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}
		}
		
		if (start < j) {
			quickSort(input, start, pivot);
		}
		
		if (i < end) {
			quickSort(input, pivot, end);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {1234,15,23,34,15,642626,1,41};
		QuickSort qs = new QuickSort();
		qs.sort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}