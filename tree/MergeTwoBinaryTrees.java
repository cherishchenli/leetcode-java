package tree;

public class MergeTwoBinaryTrees {

	public TreeNode solution(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null)
			return t1 == null ? t2 : t1;

		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = solution(t1.left, t2.left);
		node.right = solution(t1.right, t2.right);
		return node;
	}

}
