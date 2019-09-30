package tree;

public class ConstructBinaryTreeFromInorderPostorder {

	public TreeNode solution(int[] inorder, int[] postorder) {
		return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
		if (inStart > inEnd || postEnd < 0)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.right = helper(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
		root.left = helper(postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1, inorder, postorder);

		return root;
	}

}
