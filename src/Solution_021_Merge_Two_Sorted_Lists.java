/**
 * 
 * Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */
/*
 * Notice: 注意判断输入是不是有空串。
 */

public class Solution_021_Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
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
