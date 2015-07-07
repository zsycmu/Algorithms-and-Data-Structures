/*
 * Remove Duplicates from Sorted List II Total Accepted: 37260 Total Submissions: 149545 My Submissions Question Solution 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 */

public class Solution_082_Remove_Duplicates_from_Sorted_List_II {
	public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode fast;
        ListNode slow;
        dummy.next = head;
        fast = head;
        slow = dummy;
        
        while (fast != null && fast.next != null) {
        	if (fast.val != fast.next.val) {
        		slow = slow.next;
        		fast = fast.next;
        	} else {
        		while (fast != null && fast.next != null && fast.val == fast.next.val) {
        			fast = fast.next;
        		}
        		slow.next = fast.next;
        		fast = fast.next;
        	}
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		
		ListNode result = deleteDuplicates(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
