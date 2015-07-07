/*
 * 
 * Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 */

public class Solution_092_Reverse_Linked_List_II {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while (n > 0) {
        	fast = fast.next;
        	n--;
        }
        
        while (m - 1 > 0) {
        	slow = slow.next;
        	m--;
        }
        
        ListNode reversePart = slow.next;
        ListNode remainPart = fast.next;
        fast.next = null;
        ListNode reverse = reverse(reversePart);
        ListNode reverseRun = reverse;
        while (reverseRun.next != null) {
        	reverseRun = reverseRun.next;
        }
        slow.next = reverse;
        reverseRun.next = remainPart;
        
        return dummy.next;
    }
	
	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = null;
		ListNode pre = dummy;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode result = reverseBetween(head, 2, 4);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
