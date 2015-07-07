/**
 * 
 * Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 */
/*
 * Notice: Run an sample to check.
 */

public class Solution_019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return head.next;
            }
        }
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}
