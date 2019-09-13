package hash_table;

import java.util.*;

public class MaxPointsOnLine {

	class Point {
		int x = 0, y = 0;
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;

		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();

		int max = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int overlap = 0, localMax = 0;
			for (int j = i + 1; j < points.length; j++) {
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = generateGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}
				List<Integer> slope = Arrays.asList(x, y);
				map.put(slope, map.getOrDefault(slope, 0) + 1);
				localMax = Math.max(localMax, map.get(slope));
			}
			max = Math.max(max, localMax + overlap + 1);
		}

		return max;
	}

	private int generateGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return generateGCD(b, a % b);
	}

}
