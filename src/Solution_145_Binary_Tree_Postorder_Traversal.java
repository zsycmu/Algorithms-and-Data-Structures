import java.util.HashMap;

/**
 * 
 * Binary Tree Postorder Traversal
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 *
 */

/*
 * Notice: 注意这些点都是在一个竖着的直线上得情况。亮点重合是斜率无穷大的特殊情况。
 */
public class Solution_145_Binary_Tree_Postorder_Traversal {
	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		if (points.length <= 2) {
			return points.length;
		}

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;
			map.clear();
			Point p = points[i];
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point q = points[j];
				double slope = 0.0;
				if (p.x == q.x && p.y == q.y) {
					duplicate++;
					continue;
				} else {
					slope = 1.0 * (p.y - q.y) / (p.x - q.x);
				}

				if (map.containsKey(slope)) {
					map.put(slope, map.get(slope) + 1);
				} else {
					map.put(slope, 1);
				}
			}
			if (map.isEmpty()) {
				max = duplicate;
			}
			for (double key : map.keySet()) {
				max = Math.max(max, duplicate + map.get(key));
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 1);
		Point p3 = new Point(1, 1);

		Point[] input = { p1, p2, p3 };

		System.out.println(maxPoints(input));
	}
}
