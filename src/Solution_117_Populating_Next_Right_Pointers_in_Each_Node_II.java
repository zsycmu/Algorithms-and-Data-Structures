import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Populating Next Right Pointers in Each Node II
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 */

/*
 * Note: it is the same with first one.
 */

public class Solution_117_Populating_Next_Right_Pointers_in_Each_Node_II {
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
