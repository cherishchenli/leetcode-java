package tree;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> solution(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();

		Map<Integer, List<Integer>> map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		queue.offer(root);
		cols.offer(0);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int col = cols.poll();

			List<Integer> list = map.getOrDefault(col, new ArrayList<Integer>());
			list.add(node.val);
			map.put(col, list);

			if (node.left != null) {
				queue.offer(node.left);
				cols.offer(col - 1);
			}

			if (node.right != null) {
				queue.offer(node.right);
				cols.offer(col + 1);
			}
		}

		return new ArrayList<List<Integer>>(map.values());
	}

}
