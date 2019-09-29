package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

	/* iterative */
    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (fromLeft)
                    list.add(node.val);
                else
                    list.addFirst(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            fromLeft = !fromLeft;
            result.add(list);
        }
        
        return result;
    }
    
    /* recursive */
    public List<List<Integer>> solution2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    
    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null)
            return;

        if (result.size() <= level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }

        List<Integer> collection  = result.get(level);
        if (level % 2 == 0)
            collection.add(root.val);
        else
            collection.add(0, root.val);

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
	
}
