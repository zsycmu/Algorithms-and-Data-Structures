/**
 * 
 * Unique Binary Search Trees II
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *    
 */
/*
 * Notice: In the loop, the i should be between 1 and n. So the range could be i = start; i <= end; i++
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_095_Unique_Binary_Search_Trees_II {
	public static List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}
	
	public static List<TreeNode> helper(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		
		if (start > end) {
			result.add(null);
			return result;
		}
		
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = helper(start, i - 1);
			List<TreeNode> right = helper(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode node = new TreeNode(i);
					node.left = l;
					node.right = r;
					result.add(node);
				}
			}
		}
		
		return result;
	}
}
