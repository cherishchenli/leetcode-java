package array;

public class FlipImage {

	public int[][] solution(int[][] A) {
		int n = A[0].length;
		for (int[] row : A)
			for (int i = 0; i * 2 < n; i++)
				if (row[i] == row[n - i - 1])
					row[i] = row[n - i - 1] ^= 1;
		return A;
	}

}
