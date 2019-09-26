package tree;

import java.util.List;
import java.util.ArrayList;

public class FindLeavesOfBinaryTree {

	public List<List<Integer>> solution(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(root, result);
		return result;
	}

	private int dfs(TreeNode root, List<List<Integer>> result) {
		if (root == null)
			return 0;

		int depth = Math.max(dfs(root.left, result), dfs(root.right, result)) + 1;
		if (result.size() < depth)
			result.add(new ArrayList<>());
		result.get(depth - 1).add(root.val);
		root = null;

		return depth;
	}

}
