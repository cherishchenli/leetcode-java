package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/* recursive */
	public List<Integer> solution1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root, result);
		return result;
	}

	private void inorderTraversal(TreeNode root, List<Integer> result) {
	    if (root == null) return;
        
	    inorderTraversal(root.left, result);
	    result.add(root.val);
	    inorderTraversal(root.right, result);
	}

	/* iterative */
	public List<Integer> solution2(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode node = root;
	    while (!stack.isEmpty() || node != null) {
	        if (node != null) {
	            stack.push(node);
	            node = node.left;
	        } else {
	            node = stack.pop();
	            result.add(node.val);
	            node = node.right;   
	        }
	    }
	    return result;
	}

	/* Morris traversal */
	public List<Integer> solution3(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    TreeNode node = root;
	    while (node != null) {
	        if (node.left == null) {
	            result.add(node.val);
	            node = node.right;
	        } else {
	            TreeNode pre = node.left;
	            while (pre.right != null && pre.right != node)
	                pre = pre.right;
	            if (pre.right == null) {
	                pre.right = node;
	                node = node.left;
	            } else {
	                result.add(node.val);
	                pre.right = null;
	                node = node.right;
	            }
	        }
	    }
		return result;
	}

}
