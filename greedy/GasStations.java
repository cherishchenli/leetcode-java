package greedy;

public class GasStations {

	public int solution(int[] gas, int[] cost) {
		int start = 0, total = 0, tank = 0;
		for (int i = 0; i < gas.length; i++) {
			if ((tank += gas[i] - cost[i]) < 0) {
				start = i + 1;
				tank = 0;
			}
			total += gas[i] - cost[i];
		}
		return total < 0 ? -1 : start;
	}

}
