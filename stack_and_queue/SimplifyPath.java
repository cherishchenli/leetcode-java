package stack_and_queue;

import java.util.LinkedList;

public class SimplifyPath {

	public String solution(String path) {
		LinkedList<String> list = new LinkedList<>();
		for (String s : path.split("/")) {
			if (s.length() == 0 || s.equals("."))
				continue;
			if (s.equals("..")) {
				if (!list.isEmpty())
					list.removeLast();
			} else
				list.addLast(s);
		}

		if (list.isEmpty())
			return "/";

		StringBuilder sb = new StringBuilder();
		for (String s : list)
			sb.append("/" + s);
		return sb.toString();
	}

}
