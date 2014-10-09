package Code;
/*
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Element {
    public static int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        
        int size = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == elem) {
        		continue;
        	}
        	A[size] = A[i];
        	size++;
        }
        
        return size;
    }
    
    public static void main(String[] args) {
    	int[] A = {1, 2, 3, 4, 5, 3, 3, 3, 6, 6, 3, 3, 3, 3, 3, 3, 3, 3, 7, 3, 8, 3, 9, 3};
    	int elem = 3;
    	int result = removeElement(A, elem);
    	System.out.print(result);
    }
}