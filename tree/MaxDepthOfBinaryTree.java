package tree;

public class MaxDepthOfBinaryTree {

	public int solution(TreeNode root) {
		return (root == null) ? 0 : Math.max(solution(root.left), solution(root.right)) + 1;
	}

}
