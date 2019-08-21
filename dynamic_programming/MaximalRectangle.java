package dynamic_programming;

import java.util.Arrays;

public class MaximalRectangle {

	public int solution(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length, max = 0;
		int[] left = new int[n], right = new int[n], height = new int[n];
		Arrays.fill(right, n);

		for (int i = 0; i < m; i++) {
			int currLeft = 0, currRight = n;
			// calculate left
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], currLeft);
				else {
					left[j] = 0;
					currLeft = j + 1;
				}
			}
			// calculate right
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], currRight);
				else {
					right[j] = n;
					currRight = j;
				}
			}
			// calculate height and max
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}

		return max;
	}

}
