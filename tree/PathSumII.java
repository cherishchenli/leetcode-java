package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class PathSumII {

	public List<List<Integer>> solution(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root != null)
			helper(root, sum, result, new ArrayList<Integer>());
		return result;
	}

	private void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> path) {
		if (node.left == null && node.right == null) {
			if (sum == node.val) {
				path.add(node.val);
				result.add(new LinkedList<>(path));
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(node.val);
		if (node.left != null)
			helper(node.left, sum - node.val, result, path);
		if (node.right != null)
			helper(node.right, sum - node.val, result, path);
		path.remove(path.size() - 1);
	}

}
