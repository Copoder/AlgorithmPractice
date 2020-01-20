
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * #102
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 */
public class LevelOrder {
    //fixme 官方解题思路
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = queue.poll();
                List<Integer> integers = result.get(level);
                integers.add(pollNode.val);
                if (pollNode.left != null) queue.add(pollNode.left);
                if (pollNode.right != null) queue.add(pollNode.right);
            }
            level++;
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
