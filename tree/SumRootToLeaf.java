package tree;

public class SumRootToLeaf {

	public int solution(TreeNode root) {
		return helper(root, 0);
	}

	private int helper(TreeNode node, int prev) {
		if (node == null)
			return 0;
		int curr = prev * 10 + node.val;
		if (node.left == null && node.right == null)
			return curr;
		return helper(node.left, curr) + helper(node.right, curr);
	}

}
