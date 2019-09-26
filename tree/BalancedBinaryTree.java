package tree;

public class BalancedBinaryTree {
	public boolean solution(TreeNode root) {
		return height(root) != -1;
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = height(root.left), rightHeight = height(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
