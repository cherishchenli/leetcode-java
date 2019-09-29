package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	/* BFS */
	public List<List<Integer>> solution1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> currLevel = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = queue.poll();
				currLevel.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(currLevel);
		}

		return result;
	}

	/* DFS */
	public List<List<Integer>> solution2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(root, result, 0);
		return result;
	}

	private void dfs(TreeNode root, List<List<Integer>> result, int level) {
		if (root == null)
			return;
		if (level == result.size())
			result.add(new LinkedList<Integer>());
		result.get(level).add(root.val);

		dfs(root.left, result, level + 1);
		dfs(root.right, result, level + 1);
	}

}
