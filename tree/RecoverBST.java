package tree;

public class RecoverBST {

	private TreeNode first, second, prev = new TreeNode(Integer.MIN_VALUE);

	public void solution(TreeNode root) {
		dfs(root);
		swap(first, second);
	}

	private void dfs(TreeNode root) {
		if (root == null)
			return;

		dfs(root.left);

		if (first == null && prev.val >= root.val) {
			first = prev;
		}

		if (first != null && prev.val >= root.val) {
			second = root;
		}

		prev = root;

		dfs(root.right);
	}

	private void swap(TreeNode node1, TreeNode node2) {
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}

}
