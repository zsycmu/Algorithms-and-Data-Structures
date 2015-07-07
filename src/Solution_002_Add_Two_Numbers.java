/**
 * 
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */
/*
 * Notice: l1, l2, 和 carry 可以放到一个循环里面来解决。
 */

public class Solution_002_Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        
        while (l1 != null || l2 != null || carry != 0) {
            int temp = 0;
            if (l1 != null) {
                temp = temp + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp = temp + l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                temp = temp + carry;
            }
            result.next = new ListNode(temp % 10);
            carry = temp / 10;
            result = result.next;
        }
        
        return dummy.next;
    }
}
