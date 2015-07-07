/**
 * Validate Binary Search Tree Total 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 */

/*
 * Note: the empty tree is a valid binary search tree. The number range should set to long.
 */

public class Solution_098_Validate_Binary_Search_Tree {
	public static boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        if (root.left == null && root.right == null) {
        	return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	public static boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		
		if (root.val <= min || root.val >= max) {
			return false;
		}
		
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		System.out.print(isValidBST(root));
	}
}
