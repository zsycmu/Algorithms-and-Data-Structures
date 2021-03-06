/**
 * 
 * Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
/*
 * Notice: Think it very carefully and you can get it.
 */

public class Solution_112_Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        target = target + root.val;
        if (target == sum && root.left == null && root.right == null) {
            return true;
        }
        
        return helper(root.left, sum, target) || helper(root.right, sum, target);
    }
}
