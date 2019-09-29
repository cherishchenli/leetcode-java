package tree;

import java.util.*;

public class BinaryTreeRightSideView {

	/* BFS */
	public List<Integer> solution1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = queue.poll();
				if (i == levelNum - 1)
					result.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}

		return result;
	}

	/* DFS */
	public List<Integer> solution2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result, 0);
		return result;
	}

	private void helper(TreeNode node, List<Integer> result, int depth) {
		if (node == null)
			return;

		if (result.size() == depth)
			result.add(node.val);

		helper(node.right, result, depth + 1);
		helper(node.left, result, depth + 1);
	}

}
