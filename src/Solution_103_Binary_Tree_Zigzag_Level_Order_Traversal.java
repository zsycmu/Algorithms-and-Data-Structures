/**
 * 
 * Binary Tree Zigzag Level Order Traversal Total Accepted: 30530 Total Submissions: 115367 My Submissions Question Solution 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List result = new ArrayList();
        if (root == null) {
        	return result;
        }
        
        boolean order = true;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
        		TreeNode temp = queue.poll();
        		list.add(temp.val);
        		if (temp.left != null) {
        			queue.offer(temp.left);
        		}
        		if (temp.right != null) {
        			queue.offer(temp.right);
        		}
        	}
        	if (order) {
        		result.add(list);
        		order = false;
        	} else {
        		result.add(reverse(list));
        		order = true;
        	}
        }
        
        return result;
    }
	
	private static ArrayList<Integer> reverse(ArrayList<Integer> input) {
		if (input == null) {
			return null;
		}
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for (int i = input.size() - 1; i>= 0; i--) {
			temp.add(input.get(i));
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		node.left = new TreeNode(1);
		node.right = new TreeNode(2);
		System.out.print(zigzagLevelOrder(node));
	}
}
