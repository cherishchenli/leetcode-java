package hash_table;

import java.util.*;

public class FindDuplicateFile {

	public List<List<String>> solution(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();

		for (String path : paths) {
			String[] tmp = path.split(" ");
			String prefix = tmp[0];
			for (int i = 1; i < tmp.length; i++) {
				int j = tmp[i].indexOf('(');
				String filename = tmp[i].substring(0, j);
				String content = tmp[i].substring(j + 1, tmp[i].length() - 1);
				List<String> list = map.getOrDefault(content, new ArrayList<>());
				list.add(prefix + "/" + filename);
				map.put(content, list);
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (List<String> list : map.values())
			if (list.size() > 1)
				result.add(list);

		return result;
	}

}
