package dynamic_programming;

public class CountingBits {

	public int[] solution(int num) {
		int dp[] = new int[num + 1];
		for (int i = 1; i <= num; i++)
			dp[i] = i % 2 + dp[i / 2];
		return dp;
	}

}
