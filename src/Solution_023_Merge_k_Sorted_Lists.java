

/**
 * 
 * Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_023_Merge_k_Sorted_Lists {
	
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
        	return null;
        }
		
		class compareListNode implements Comparator<ListNode> {
			public int compare(ListNode l1, ListNode l2) {
				if (l1.val < l2.val) {
					return -1;
				} else if (l1.val > l2.val) {
					return 1;
				} else {
					return 0;
				}
			}
		}
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new compareListNode());
		
		ListNode result = new ListNode(0);
		ListNode dummy = result;
		
		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}
		
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			result.next = node;
			result = result.next;
			if (node.next != null) {
				queue.offer(node.next);
			}
		}
		
		return dummy.next;
    }
}
