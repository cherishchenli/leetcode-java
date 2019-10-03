package tree;

import java.util.Map;
import java.util.HashMap;

public class HouseRobberIII {

	public int solution1(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		return helper(root, map);
	}

	public int solution2(TreeNode root) {
		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	private int helper(TreeNode node, Map<TreeNode, Integer> map) {
		if (node == null)
			return 0;
		if (map.containsKey(node))
			return map.get(node);

		int result = node.val;
		if (node.left != null)
			result += helper(node.left.left, map) + helper(node.left.right, map);
		if (node.right != null)
			result += helper(node.right.left, map) + helper(node.right.right, map);

		result = Math.max(result, helper(node.left, map) + helper(node.right, map));
		map.put(node, result);
		return result;
	}

	private int[] helper(TreeNode node) {
		if (node == null)
			return new int[2];

		int[] left = helper(node.left);
		int[] right = helper(node.right);
		int[] result = new int[2];

		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = node.val + left[0] + right[0];

		return result;
	}

}
