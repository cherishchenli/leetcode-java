package tree;

import java.util.Stack;

public class SymmetricTree {

	/* recursive solution */
	public boolean solution1(TreeNode root) {
		if (root == null)
			return true;

		return helper(root.left, root.right);
	}

	/* iterative solution */
	public boolean solution2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pop(), right = stack.pop();
			if (left == null && right == null)
				continue;
			if (left == null || right == null || left.val != right.val)
				return false;
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null || left.val != right.val)
			return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}
