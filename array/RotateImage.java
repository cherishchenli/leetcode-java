package array;

public class RotateImage {

	public void solution1(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}

	public void solution2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}
	}

}
