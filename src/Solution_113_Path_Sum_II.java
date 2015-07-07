import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */

/*
 * 
 * Note: For the recursive solution the root will become null before add to the final result. 
 * So we change the order of calculate sum and add the root value to the list.
 * 
 */

public class Solution_113_Path_Sum_II {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List result = new ArrayList();
        if (root == null) {
        	return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, root, sum);
        return result;
    }
	
	public static void helper(List result, ArrayList<Integer> list, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		
		sum = sum - root.val;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				list.add(root.val);
				ArrayList<Integer> temp = new ArrayList<Integer>(list);
				result.add(temp);
				list.remove(list.size() - 1);
			}
			
			return;
		}
		
		list.add(root.val);
		helper(result, list, root.left, sum);
		helper(result, list, root.right, sum);
		list.remove(list.size() - 1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		List result = pathSum(root, 22);
		System.out.println(result);
	}
}
