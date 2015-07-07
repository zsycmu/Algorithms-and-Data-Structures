
/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 */

/*
 * Note: 
 */

public class Solution_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
        	return null;
        }
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
	public static TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
		
		if (prestart > preend || instart > inend) {
			return null;
		}
		
		int rootValue = preorder[prestart];
		TreeNode root = new TreeNode(rootValue);
		int k = 0;
		for (int i = instart; i < inend; i++) {
			if (inorder[i] == rootValue) {
				break;
			}
			k++;
		}
		
		root.left = helper(preorder, prestart + 1, prestart + k + 1, inorder, instart, instart + k - 1);
		root.right = helper(preorder, prestart + k + 1, preend, inorder, instart + k + 1, inend);
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 1, 3};
		
		TreeNode node = buildTree(preorder, inorder);
		Util.printTreeNode(node);
	}
}
