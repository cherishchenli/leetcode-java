package tree;

import java.util.*;

public class BinaryTreePostorderTraversal {

	/* recursive */
	public List<Integer> solution1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		postorderTraversal(root, result);
		return result;
	}

	private void postorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null)
			return;

		postorderTraversal(root.left, result);
		postorderTraversal(root.right, result);
		result.add(root.val);
	}

	/* iterative */
	public List<Integer> solution2(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				result.addFirst(node.val);
				node = node.left;
			} else {
				node = stack.pop();
				node = node.right;
			}
		}
		return result;
	}

	/* Morris traversal */
	public List<Integer> solution3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode dummy = new TreeNode(0), node = dummy;
		dummy.left = root;
		while (node != null) {
			if (node.left != null) {
				TreeNode pre = node.left;
				while (pre.right != null && pre.right != node)
					pre = pre.right;
				if (pre.right == null) {
					pre.right = node;
					node = node.left;
				} else {
					// reverse nodes from pre to node
					reverse(node, node.left);

					// add nodes to result list
					TreeNode tmp = pre;
					while (tmp != node) {
						result.add(tmp.val);
						tmp = tmp.right;
					}

					// restore the nodes back
					reverse(node, pre);

					// reset the pointer of leaf node
					pre.right = null;
					node = node.right;
				}
			} else {
				node = node.right;
			}
		}
		return result;
	}

	private void reverse(TreeNode first, TreeNode next) {
		TreeNode end = first, last;
		while (next != end) {
			last = next.right;
			next.right = first;
			first = next;
			next = last;
		}
	}

}
