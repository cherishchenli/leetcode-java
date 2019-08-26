package array;

public class TransposeMatrix {

	public int[][] transpose(int[][] A) {
		int m = A.length, n = A[0].length;
		int[][] B = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				B[i][j] = A[j][i];
		}
		return B;
	}

}
