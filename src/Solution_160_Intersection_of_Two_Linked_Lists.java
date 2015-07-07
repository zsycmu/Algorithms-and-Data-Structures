/**
 * 
 * Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
/*
 * 
 */
public class Solution_160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode A = headA;
        ListNode B = headB;
        int headA_len = 0;
        int headB_len = 0;
        
        while (headA != null) {
            headA = headA.next;
            headA_len++;
        }
        
        while (headB != null) {
            headB = headB.next;
            headB_len++;
        }
        int diff = Math.abs(headA_len - headB_len);
        if (headA_len > headB_len) {
            while (A != null && diff > 0) {
                A = A.next;
                diff--;
            }
        } else {
            while (B != null && diff > 0) {
                B = B.next;
                diff--;
            }
        }
        
        while (A != null && B != null) {
            if (A == B) {
                return A;
            }
            A = A.next;
            B = B.next;
        }
        
        return null;
    }
}
