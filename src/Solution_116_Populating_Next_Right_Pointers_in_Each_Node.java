import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree
 *
 *    struct TreeLinkNode {
 *      TreeLinkNode *left;
 *      TreeLinkNode *right;
 *      TreeLinkNode *next;
 *    }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *         1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 *    
 *    After calling your function, the tree should look like:
 *         1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \  / \
 *    4->5->6->7 -> NULL
 *
 */

/*
 * 
 * Note: For the pre TreeLinkNode, if it is null, 
 * let it to be the node or let the node to be the next of the pre.
 * 
 */

public class Solution_116_Populating_Next_Right_Pointers_in_Each_Node {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode pre = null;
			for (int i = 0; i < size; i++) {
				TreeLinkNode temp = queue.poll();
				if (pre == null) {
					pre = temp;
				} else {
					pre.next = temp;
					pre = pre.next;
				}
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
		}
    }
}
