/**
 * 
 * Reverse Nodes in k-Group 
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 */

/*
 * Note: https://github.com/rffffffff007/leetcode/blob/master/Reverse%20Nodes%20in%20k-Group.java
 */


public class Solution_025_Reverse_Nodes_in_k_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		int len = getLen(head);
		for (int i = 0; i < len / k; i++) {
			ListNode q = reverse(p.next, k);
			ListNode next = p.next;
			p.next = q;
			p = next;
		}
		
		return dummy.next;
	}
	
	public int getLen(ListNode head) {
		if (head == null) {
			return 0;
		}
		
		int len = 0;
		
		while (head != null) {
			head = head.next;
			len++;
		}
		
		return len;
	}
	
	public ListNode reverse(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode pre = null;
		ListNode cur = head;
		
		for (int i = 0; i < n; i++) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		head.next = cur;
		return pre;
	}
}
