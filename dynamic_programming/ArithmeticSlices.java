package dynamic_programming;

public class ArithmeticSlices {

	public int solution(int[] A) {
		int curr = 0, count = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				curr++;
				count += curr;
			} else
				curr = 0;
		}
		return count;
	}

}
