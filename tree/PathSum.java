package tree;

public class PathSum {

	public boolean solution(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return sum == root.val;
		return solution(root.left, sum - root.val) || solution(root.right, sum - root.val);
	}

}
