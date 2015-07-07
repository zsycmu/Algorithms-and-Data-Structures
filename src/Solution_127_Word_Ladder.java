import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Solution_127_Word_Ladder {
	public static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            return 0;
        }
        
        int result = 1;
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                for (int j = 0; j < temp.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newString = getNewString(temp, j, c);
                        if (dict.contains(newString)) {
                            if (newString.equals(end)) {
                                return result + 1;
                            } else {
                                dict.remove(newString);
                                queue.offer(newString);
                            }
                        }
                    }
                }
            }
            result++;
        }
        
        return 0;
    }
    
    public static String getNewString(String s, int i, char c) {
        char[] chrs = s.toCharArray();
        chrs[i] = c;
        StringBuilder sb = new StringBuilder();
        for (char chr : chrs) {
            sb.append(chr);
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("c");
		set.add("d");
		int result = ladderLength("a", "c", set);
		System.out.println(result);
	}
}
