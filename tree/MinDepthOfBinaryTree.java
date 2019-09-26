package tree;

public class MinDepthOfBinaryTree {

	public int solution(TreeNode root) {
		if (root == null)
			return 0;

		int left = solution(root.left), right = solution(root.right);
		if (left == 0)
			return right + 1;
		else if (right == 0)
			return left + 1;
		else
			return Math.min(left, right) + 1;
	}

}
