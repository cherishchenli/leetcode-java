package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		return sb.toString();
	}

	private void preorder(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("N" + " ");
			return;
		}
		sb.append(root.val + " ");
		preorder(root.left, sb);
		preorder(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0 || data.equals("N"))
			return null;

		String[] values = data.split(" ");
		Queue<String> queue = new LinkedList<>();
		for (String val : values)
			queue.offer(val);
		return constructBT(queue);
	}

	private TreeNode constructBT(Queue<String> queue) {
		if (queue.isEmpty())
			return null;

		String val = queue.poll();
		if (val.equals("N"))
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = constructBT(queue);
		root.right = constructBT(queue);
		return root;
	}

}
