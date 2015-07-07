/**
 * 
 * Copy List with Random Pointer 
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 */

import java.util.HashMap;

public class Solution_138_Copy_List_with_Random_Pointer {
public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        	return null;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode dummy = head;
        RandomListNode result = new RandomListNode(0);
        RandomListNode newDummy = result;
        while (dummy != null) {
        	RandomListNode newNode = new RandomListNode(dummy.label);
        	newDummy.next = newNode;
        	map.put(dummy, newNode);
        	dummy = dummy.next;
        	newDummy = newDummy.next;
        }
        
        for (RandomListNode node : map.keySet()) {
        	RandomListNode oldRandom = node.random;
        	map.get(node).random = map.get(oldRandom);
        }
        
        return result.next;
    }
}

