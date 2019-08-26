package array;

public class SpiralMatrixII {

	public int[][] solution(int n) {
		int[][] result = new int[n][n];

		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int num = 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				result[rowStart][i] = num++;
			}
			rowStart++;

			for (int i = rowStart; i <= rowEnd; i++) {
				result[i][colEnd] = num++;
			}
			colEnd--;

			for (int i = colEnd; i >= colStart; i--) {
				if (rowStart <= rowEnd)
					result[rowEnd][i] = num++;
			}
			rowEnd--;

			for (int i = rowEnd; i >= rowStart; i--) {
				if (colStart <= colEnd)
					result[i][colStart] = num++;
			}
			colStart++;

		}

		return result;
	}

}
