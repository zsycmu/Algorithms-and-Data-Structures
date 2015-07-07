/**
 * 
 * Insertion Sort List 
 * 
 * Sort a linked list using insertion sort.
 *
 */
/*
 * 
 */

public class Solution_147_Insertion_Sort_List {
	public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
        	ListNode node = dummy;
        	while (node.next != null && node.next.val < head.val) {
        		node = node.next;
        	}
        	
        	ListNode temp = head.next;
        	head.next = node.next;
        	node.next = head;
        	head = temp;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(9);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(7);
		
		ListNode result = insertionSortList(head);
		
		while (result != null) {
			System.out.println(result.val + " ");
			result = result.next;
		}
	}
}
