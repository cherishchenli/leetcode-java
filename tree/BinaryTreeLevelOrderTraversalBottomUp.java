package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalBottomUp {

	public List<List<Integer>> solution(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		helper(result, root, 0);
		return result;
	}

	private void helper(List<List<Integer>> result, TreeNode node, int level) {
		if (node == null)
			return;
		if (level >= result.size()) {
			result.add(0, new LinkedList<Integer>());
		}
		helper(result, node.left, level + 1);
		helper(result, node.right, level + 1);
		result.get(result.size() - level - 1).add(node.val);
	}

}
