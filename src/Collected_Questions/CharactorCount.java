package Collected_Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Cell {
	char c;
	int count;
	
	public Cell(char c, int count) {
		this.c = c;
		this.count = count;
	}
}

public class CharactorCount {
	
	public static ArrayList<Cell> count (String input)  {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		if (input == null || input.length() == 0) {
			return result;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (!map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), 1);
			} else {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			}
		}
		
		Comparator<Cell> comparator = new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.count < c2.count) {
					return -1;
				} else if (c1.count > c2.count) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		
		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(comparator);
		
		for (char c : map.keySet()) {
			int count = map.get(c);
			Cell cell = new Cell(c, count);
			queue.add(cell);
		}
		
		while (!queue.isEmpty()) {
			result.add(queue.poll());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String input = "apple";
		ArrayList<Cell> result = count(input);
		
		for (Cell c : result) {
			System.out.println(c.c + " " + c.count);
		}
	}
}
