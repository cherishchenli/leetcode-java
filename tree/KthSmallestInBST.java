package tree;

import java.util.Stack;

public class KthSmallestInBST {

	public int solution(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		int count = 0;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				if (++count == k)
					return node.val;
				node = node.right;
			}
		}

		return Integer.MIN_VALUE;
	}

}
