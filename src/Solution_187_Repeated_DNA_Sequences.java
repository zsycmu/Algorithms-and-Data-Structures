import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 */
/*
 * Notice: http://yuanhsh.iteye.com/blog/2185976
 */

public class Solution_187_Repeated_DNA_Sequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        List result = new ArrayList();
        if (s == null || s.length() == 0) {
        	return result;
        }
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i + 9 < s.length(); i++) {
        	String sub = s.substring(i, i + 10);
        	if (!set.contains(sub)) {
        		set.add(sub);
        	} else {
        		result.add(sub);
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(input));
	}
}
