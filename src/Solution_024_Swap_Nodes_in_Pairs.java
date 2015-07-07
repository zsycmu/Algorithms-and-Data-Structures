
public class Solution_024_Swap_Nodes_in_Pairs {
	public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = head;
        
        while (first != null && first.next != null) {
            ListNode second = first.next;
            ListNode next = second.next;
            pre.next = second;
            second.next = first;
            first.next = next;
            pre = first;
            first = next;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
		
		ListNode head = swapPairs(l1);
		
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
