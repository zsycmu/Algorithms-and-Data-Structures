
/**
 * 
 * Convert Sorted List to Binary Search Tree Total Accepted: 36894 Total Submissions: 132617 My Submissions Question Solution 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 */

/*
 * Note: The most important thing is to deal with the single node. When the head is since node, return it as a treenode directly.
 * when we try to get the pre node. If the head is a single node, the pre should be equal to slow.
 */

public class Solution_109_Convert_Sorted_List_to_Binary_Search_Tree {
	public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        return helper(head);
    }
	
	public static TreeNode helper(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode left = getLeftNodeFromList(head);
		ListNode mid = left.next;
		TreeNode node = new TreeNode(mid.val);
		left.next = null;
		node.left = helper(head);
		node.right = helper(mid.next);
		
		return node;
	}
	
	public static ListNode getLeftNodeFromList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (pre == slow) {
			return pre;
		} else {
			while (pre.next != slow) {
				pre = pre.next;
			}
		}
		
		return pre;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		
		TreeNode tree = sortedListToBST(node);
		
		Util.printTreeNode(tree);
	}
}

//This is a better solution:
//public TreeNode sortedListToBST(ListNode head) {
//    if (head == null) {
//        return null;
//    }
//    
//    return helper(head);
//}
//
//private TreeNode helper(ListNode head) {
//    if (head == null) {
//        return null;
//    }
//    if (head.next == null) {
//        return new TreeNode(head.val);
//    }
//    ListNode left = findLeftNode(head);
//    ListNode mid = left.next;
//    
//    TreeNode node = new TreeNode(mid.val);
//    left.next = null;
//    node.left = helper(head);
//    node.right = helper(mid.next);
//    
//    return node;
//}
//
//private ListNode findLeftNode(ListNode node) {
//    // if (node == null || node.next == null) {
//    //     return node;
//    // }
//    ListNode dummy = new ListNode(0);
//    dummy.next = node;
//    ListNode slow = dummy;
//    ListNode fast = slow.next;
//    
//    while (fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//    }
//    
//    return slow;
//}
