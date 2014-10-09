package Util;

import java.util.ArrayList;

public class printResult {
	public void printListNode(ListNode node) {
		if (node == null) {
			System.out.println("Null");
		}
		
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	public void printArrayList(ArrayList<Object> list) {
		System.out.print(list);
	}
}
