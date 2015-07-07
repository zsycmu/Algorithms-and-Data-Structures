/**
 * 
 * Remove Element
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length. The order of elements can be changed. It doesn't
 * matter what you leave beyond the new length.
 *
 */
public class Solution_027_Remove_Element {
	public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int i = -1;
        
        for (int j = 0; j < A.length; j++) {
            if (A[j] != elem) {
                A[++i] = A[j];
            }
        }
        
        return i + 1;
    }
}
