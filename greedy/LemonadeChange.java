package greedy;

public class LemonadeChange {

	public boolean solution(int[] bills) {
		int b5 = 0, b10 = 0;
		for (int bill : bills) {
			if (bill == 5)
				b5++;
			else if (bill == 10) {
				b5--;
				b10++;
			} else {
				if (b10 >= 1) {
					b10--;
					b5--;
				} else
					b5 -= 3;
			}
			if (b5 < 0)
				return false;
		}
		return true;
	}
}
