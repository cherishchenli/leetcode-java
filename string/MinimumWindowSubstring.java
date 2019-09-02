package string;

public class MinimumWindowSubstring {

    public String solution(String s, String t) {
        int[] map = new int[128];

		for (char c : t.toCharArray())
			map[c]++;
        
        int counter = t.length(), left = 0, right = 0;
        int[] result = new int[]{Integer.MAX_VALUE, 0}; //len, start
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0)
				counter--;
			map[c]--;
            while (counter == 0) {
                if (right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                }
                char tmp = s.charAt(left);
                if (map[tmp] == 0)
					counter++;
				map[tmp]++;
				left++;
            }
            right++;
        }
        
        return result[0] == Integer.MAX_VALUE ? "" : s.substring(result[1], result[0] + result[1]);
    }
	
}
