/**
 * 
 * Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 */

/*
 * Notice: 注意slow最后和fast相等的情况。
 */

public class Solution_061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode end = head;
        int len = 0;
        while (end != null) {
            end = end.next;
            len++;
        }
        k = k % len;
        while (k > 0) {
            fast = fast.next;
            k--;
            if (fast == null) {
                fast = head; //Begin from the head;
            }
        }
        if (slow == fast) {
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode result = slow.next;
        fast.next = head;
        slow.next = null;
        
        return result;
    }
}