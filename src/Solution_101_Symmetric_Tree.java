/**
 * 
 * Symmetric Tree 
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 */
/*
 * Notice: 
 */
public class Solution_101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        
        if (right == null) {
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
