package tree;

public class FlattenBinaryTreeToLinkedList {

	public void solution1(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			TreeNode left = root.left, right = root.right, rightmost = left;
			while (rightmost.right != null)
				rightmost = rightmost.right;
			rightmost.right = right;
			root.right = left;
			root.left = null;
		}
		solution1(root.right);
	}

	public void solution2(TreeNode root) {
		root = helper(root, null);
	}

	private TreeNode helper(TreeNode root, TreeNode prev) {
		if (root == null)
			return prev;

		prev = helper(root.right, prev);
		prev = helper(root.left, prev);

		root.right = prev;
		root.left = null;
		prev = root;
		return root;
	}

}
