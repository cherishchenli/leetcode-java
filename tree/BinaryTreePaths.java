package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public List<String> solution(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root != null)
			helper(root, result, "");
		return result;
	}

	private void helper(TreeNode node, List<String> result, String path) {
		if (node.left == null && node.right == null) {
			result.add(path + node.val);
			return;
		}

		if (node.left != null)
			helper(node.left, result, path + node.val + "->");
		if (node.right != null)
			helper(node.right, result, path + node.val + "->");
	}

}
