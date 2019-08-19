package dynamic_programming;

public class PaintFence {

	public int solution(int n, int k) {
		if (n <= 0 || k <= 0 || (k == 1 && n > 2))
			return 0;

		int waysSame = 0, waysDiff = k;
		for (int i = 2; i <= n; i++) {
			int tmp = waysDiff;
			waysDiff = (waysSame + waysDiff) * (k - 1);
			waysSame = tmp;
		}
		return waysSame + waysDiff;
	}

}
