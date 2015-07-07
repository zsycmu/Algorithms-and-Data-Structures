/**
 * 
 * Linked List Cycle II 
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 *
 */

/*
 * Note: for the last while loop, we cannot return the value directly. 
 * Need to break the loop and return outside the loop.
 * 
 */

public class Solution_142_Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        if (head == null || head.next == null) {
        	return null;
        }
        
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		break;
        	}
        }
        
        if (slow == fast) {
        	fast = head;
        	while (slow != fast) {
            	slow = slow.next;
            	fast = fast.next;
            	if (slow == fast) {
            		break;
            	}
            }
        	return fast;
        }
        
        return null;
    }
}
