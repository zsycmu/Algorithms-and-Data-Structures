/**
 * 
 * Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 */

/*
 * 
 */

public class Solution_129_Sum_Root_to_Leaf_Numbers {
	public static int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        return helper(root, 0);
    }
	
	public static int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		
		return helper(root.left, sum) + helper(root.right, sum);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(0);
		node.right = new TreeNode(3);
		
		System.out.print(sumNumbers(node));
	}
}
