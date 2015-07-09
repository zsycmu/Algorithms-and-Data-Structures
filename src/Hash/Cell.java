package Hash;

public class Cell {
	private Object key;
	private Object value;
	
	public Cell(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public boolean equivalent(Cell c) {
		return equivalent(c.key);
	}
	
	public boolean equivalent(Object key) {
		return key.equals(key);
	}
	
	public Object getValue() {
		return this.value;
	}
}
