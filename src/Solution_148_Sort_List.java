/**
 * 
 * Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
/*
 * Notice: 1. 注意一开始的if判断if (head == null || head.next == null)
 * 		   2. 注意fast是head.next，不是head
 */
public class Solution_148_Sort_List {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        slow = head;
        
        ListNode firstpart = sortList(slow);
        ListNode secondpart = sortList(fast);
        
        ListNode result = merge(firstpart, secondpart);
        
        return result;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            
            result = result.next;
        }
        
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }
        
        return dummy.next;
    }
}
