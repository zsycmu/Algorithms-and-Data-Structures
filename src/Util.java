
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Util {
	public static void printTreeNode(TreeNode node) {
		if (node == null) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
		
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		node.left = new TreeNode(1);
		node.right = new TreeNode(2);
		printTreeNode(node);
	}
}
