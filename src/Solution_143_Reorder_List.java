/**
 * 
 * Reorder List
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */
public class Solution_143_Reorder_List {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        
        ListNode reverse = reverse(second);
        ListNode result = merge(first, reverse);
        head = result;
    }
    
    public ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        
        ListNode dummy = null;
        ListNode pre = dummy;
        ListNode cur = node;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        boolean order = true;
        
        while (l1 != null && l2 != null) {
            if (order) {
                result.next = l1;
                l1 = l1.next;
                order = false;
            } else {
                result.next = l2;
                l2 = l2.next;
                order = true;
            }
            result =result.next;
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
