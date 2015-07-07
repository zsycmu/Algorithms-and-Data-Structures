import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
/*
 * Notice: 往stack里面push的时候是push的node的左右，不是root的。
 */
public class Solution_144_Binary_Tree_Preorder_Traversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
}
