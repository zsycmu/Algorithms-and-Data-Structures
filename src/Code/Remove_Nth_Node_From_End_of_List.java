package Code;
import Util.ListNode;
import Util.printResult;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *  Given n will always be valid.
 *  Try to do this in one pass.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Remove_Nth_Node_From_End_of_List {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head.next != null) {
        	if (head.next.val == n) {
        		//Remove node.
        		head.next = head.next.next;
        	} else {
        		head = head.next;
        	}
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(0);
    	ListNode n2 = new ListNode(1);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(3);
    	ListNode n5 = new ListNode(3);
    	ListNode n6 = new ListNode(3);
    	ListNode n7 = new ListNode(4);
    	ListNode n8 = new ListNode(5);
    	
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	n6.next = n7;
    	n7.next = n8;
    	
    	int n = 3;
    	ListNode result = removeNthFromEnd(n1, n);
    	printResult print = new printResult();
    	print.printListNode(result);
    }
}