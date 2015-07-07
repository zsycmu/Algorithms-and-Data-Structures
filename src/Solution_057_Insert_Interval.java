import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 */

/*
 * Note: At last, we need add newIntervals. Even if the intervals is null, we need add the newInterval.
 */

public class Solution_057_Insert_Interval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List result = new ArrayList();
        
        for (Interval i : intervals) {
        	if (i.start > newInterval.end) {
        		result.add(newInterval);
        		newInterval = i;
        	} else if (i.end < newInterval.start) {
        		result.add(i);
        	} else {
        		newInterval = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
        	}
        }
        result.add(newInterval);
        return result;
    }
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,9);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		
		List<Interval> result = insert(intervals, new Interval(2, 5));
		
		for (Interval i : result) {
			System.out.print(i.start + "," + i.end + " ");
		}
	}
}
