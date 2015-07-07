/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */

/*
 * Note: no matter for the inorder or the postorder, 
 * the start position or the end position should be based on the instart, inend, or poststart or postend.
 * 
 */

public class Solution_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
        	return null;
        }
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	
	public static TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if (instart > inend || poststart > postend) {
			return null;
		}
		
		int rootValue = postorder[postend];
		int k = 0;
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == rootValue) {
				break;
			}
			k++;
		}
		
		TreeNode root = new TreeNode(rootValue);
		root.left = helper(inorder, instart, instart + k - 1, postorder, poststart, poststart + k - 1);
		root.right = helper(inorder, instart + k + 1, inend, postorder, poststart + k, postend - 1);
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2,3,4,5,6};
		int[] inorder = {3,2,1,6,5,4};
		
		TreeNode node = buildTree(preorder, inorder);
		Util.printTreeNode(node);
	}
}
