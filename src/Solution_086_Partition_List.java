/*
 * Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 */

public class Solution_086_Partition_List {
	public static ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return null;
        }
        
        ListNode small = new ListNode(0);
        ListNode smallrun = small;
        ListNode fast = new ListNode(0);
        ListNode fastrun = fast;
        
        while (head != null) {
        	if (head.val < x) {
        		smallrun.next = head;
        		smallrun = smallrun.next;
        	} else {
        		fastrun.next = head;
        		fastrun = fastrun.next;
        	}
        	head = head.next;
        }
        
        smallrun.next = fast.next;
        fastrun.next = null;
        
        return small.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		
		ListNode result = partition(head, 3);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
