package backtracking;

import java.util.*;

public class RestoreIpAddress {

	// backtracking
	public List<String> solution1(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12)
			return result;

		backtrack(result, s, "", 0);

		return result;
	}

	// brute force
	public List<String> solution2(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12)
			return result;

		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
						result.add(s1 + "." + s2 + "." + s3 + "." + s4);
				}
			}
		}

		return result;
	}

	private void backtrack(List<String> result, String s, String curr, int partNum) {
		if (s.isEmpty() || partNum == 4) {
			if (s.isEmpty() && partNum == 4)
				result.add(curr);
			return;
		}

		int maxPartLen = s.length();
		if (s.charAt(0) == '0')
			maxPartLen = 1;
		else
			maxPartLen = Math.min(maxPartLen, 3);

		for (int i = 1; i <= maxPartLen; i++) {
			String part = s.substring(0, i);
			if (Integer.valueOf(part) <= 255) {
				if (partNum == 0)
					backtrack(result, s.substring(i), curr + part, partNum + 1);
				else
					backtrack(result, s.substring(i), curr + "." + part, partNum + 1);
			}
		}
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0' && s.length() > 1)
			return false;
		if (Integer.parseInt(s) > 255)
			return false;
		return true;
	}

}
