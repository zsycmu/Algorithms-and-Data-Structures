/**
 * Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 */

/*
 * Note: the root value should be the num[mid] instead of mid.
 */

public class Solution_108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public static TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
        	return null;
        }
        
        return helper(num, 0, num.length - 1);
    }
	
	private static TreeNode helper(int[] num, int start, int end) {
		if (start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, start, mid - 1);
		root.right = helper(num, mid + 1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6};
		TreeNode root = sortedArrayToBST(input);
		Util.printTreeNode(root);
	}
}
