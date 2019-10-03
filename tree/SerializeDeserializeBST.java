package tree;

import java.util.Stack;

public class SerializeDeserializeBST {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		return sb.toString();
	}

	private void preorder(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val + " ");
		preorder(root.left, sb);
		preorder(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;

		String[] values = data.split(" ");
		int[] nums = new int[values.length];
		for (int i = 0; i < values.length; i++)
			nums[i] = Integer.parseInt(values[i]);

		TreeNode root = new TreeNode(nums[0]);
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		for (int i = 1; i < values.length; i++) {
			TreeNode temp = null;
			while (!stack.isEmpty() && nums[i] > stack.peek().val)
				temp = stack.pop();

			if (temp != null) {
				temp.right = new TreeNode(nums[i]);
				stack.push(temp.right);
			} else {
				temp = stack.peek();
				temp.left = new TreeNode(nums[i]);
				stack.push(temp.left);
			}
		}
		return root;
	}

}
