/**
 * 
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 */
public class Solution_111_Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root);
    }
    
    public int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }
}
