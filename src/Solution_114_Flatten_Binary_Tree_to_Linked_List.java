import java.util.List;

/**
 * 
 * Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * click to show hints.
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */

/*
 * 
 * Note: In the end, the root will be the most right node.
 * 
 */

public class Solution_114_Flatten_Binary_Tree_to_Linked_List {
	public static void flatten(TreeNode root) {
		helper(root);
    }
	
	public static TreeNode helper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		if (left != null) {
			root.right = left;
			root = helper(root.right);
		}
		if (right != null) {
			root.right = right;
			root = helper(root.right);
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		flatten(root);
		
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
	}
}
