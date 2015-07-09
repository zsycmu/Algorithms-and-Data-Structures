package Hash;

import java.util.LinkedList;

public class Hash {
	private static final int MAX_LENGTH = 10;
	private LinkedList<Cell>[] items;
	
	public Hash() {
		items = (LinkedList<Cell>[]) new LinkedList[MAX_LENGTH];
	}
	
	public int HashCodeOfKey(Object Key) {
		return Key.toString().length() % items.length;
	}
	
	public void put(Object key, Object value) {
		
		int x = HashCodeOfKey(key);
		if (items[x] == null) {
			items[x] = new LinkedList<Cell>();
		}
		
		LinkedList<Cell> collide = items[x];
		
		for (Cell c : collide) {
			if (c.equivalent(key)) {
				collide.remove(c);
				break;
			}
		}
		
		collide.add(new Cell(key, value));
	}
	
	public Object get(Object key) {
		
		int x = HashCodeOfKey(key);
		if (items[x] == null) {
			return null;
		}
		
		LinkedList<Cell> collided = items[x];
		
		for (Cell c : collided) {
			if (c.equivalent(key)) {
				return c.getValue();
			}
		}
		
		return null;
	}
}
