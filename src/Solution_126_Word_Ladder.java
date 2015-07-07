import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Word Ladder 
 * 
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
/*
 * Notice: 注意在哪儿result++。
 */
public class Solution_126_Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict == null) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordDict.remove(beginWord);
        int result = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                for (int j = 0; j < temp.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newString = getNewString(temp, j, c);
                        if (wordDict.contains(newString)) {
                            queue.offer(newString);
                            wordDict.remove(newString);
                            if (newString.equals(endWord)) {
                                return result + 1;
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
}
