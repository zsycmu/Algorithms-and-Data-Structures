import java.util.Stack;

/**
 * 
 * Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 */
/*
 * Note: http://yuanhsh.iteye.com/blog/2173429
 * 
 */

public class Solution_173_Binary_Search_Tree_Iterator {
	
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public Solution_173_Binary_Search_Tree_Iterator(TreeNode root) {
        pushLeft(root);
    }

	public void pushLeft(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
    
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
