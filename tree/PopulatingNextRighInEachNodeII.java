package tree;

import tree.PopulatingNextRighInEachNode.TreeLinkNode;

public class PopulatingNextRighInEachNodeII {

	public TreeLinkNode solution(TreeLinkNode root) {
		TreeLinkNode head = null, prev = null, curr = root;

		while (curr != null) {
			while (curr != null) {
				if (curr.left != null) {
					if (prev != null) {
						prev.next = curr.left;
					} else {
						head = curr.left;
					}
					prev = curr.left;
				}
				if (curr.right != null) {
					if (prev != null) {
						prev.next = curr.right;
					} else {
						head = curr.right;
					}
					prev = curr.right;
				}
				curr = curr.next;
			}
			curr = head;
			head = null;
			prev = null;
		}

		return root;
	}

}
