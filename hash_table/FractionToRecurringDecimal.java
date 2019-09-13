package hash_table;

import java.util.Map;
import java.util.HashMap;

public class FractionToRecurringDecimal {

	public String solution(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		StringBuilder result = new StringBuilder();
		result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		result.append(num / den);
		num %= den;
		if (num == 0)
			return result.toString();

		result.append(".");
		Map<Long, Integer> map = new HashMap<>();
		map.put(num, result.length());
		while (num != 0) {
			num *= 10;
			result.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				int index = map.get(num);
				result.insert(index, "(");
				result.append(")");
				break;
			} else
				map.put(num, result.length());
		}
		
		return result.toString();
	}

}
