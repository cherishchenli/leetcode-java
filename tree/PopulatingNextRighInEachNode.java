package tree;

public class PopulatingNextRighInEachNode {

	/* iterative */
	public void solution1(TreeLinkNode root) {
		if (root == null)
			return;

		TreeLinkNode prev = root;
		TreeLinkNode curr = null;
		while (prev.left != null) {
			curr = prev;
			while (curr != null) {
				curr.left.next = curr.right;
				if (curr.next != null)
					curr.right.next = curr.next.left;
				curr = curr.next;
			}
			prev = prev.left;
		}
	}

	/* recursive */
	public void solution2(TreeLinkNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null)
				root.right.next = root.next.left;
		}

		solution2(root.left);
		solution2(root.right);

	}

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

}
