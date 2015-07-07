/**
 * 
 * Merge Intervals 
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 */
/*
 * Notice:
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_056_Merge_Intervals {
	public static List<Interval> merge(List<Interval> intervals) {
        List result = new ArrayList();
        
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        
        class compareInterval implements Comparator<Interval> {
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) {
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else {
                    if (i1.end < i2.end) {
                        return -1;
                    } else if (i1.end > i2.end) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
        
        Collections.sort(intervals, new compareInterval());
        
        Interval first = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (temp.equals(first)) {
            	continue;
            }
            if (first.end < temp.start) {
                result.add(first);
                first = temp;
            } else if (first.start > temp.end) {
                result.add(temp);
            } else {
                first = new Interval(Math.min(first.start, temp.start), Math.max(first.end, temp.end));
            }
        }
        
        result.add(first);
        
        return result;
    }
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(1,3);
//		Interval i3 = new Interval(8,10);
//		Interval i4 = new Interval(15,18);
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
//		list.add(i3);
//		list.add(i4);
		
		List<Interval> result = merge(list);
		
		for (Interval i : result) {
			System.out.print(i.start + "," + i.end + "  ");
		}
	}
}
