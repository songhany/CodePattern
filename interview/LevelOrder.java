package interview;

import java.util.*;

class LevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) return levels;

    Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    queue.offer(root);
    int level = 0;
    while (!queue.isEmpty()) {
      levels.add(new ArrayList<Integer>());  // start the current level

      int levelLength = queue.size();  // number of elements in the current level
      for (int i = 0; i < levelLength; i++) {
        TreeNode node = queue.poll();
        levels.get(level).add(node.val);  // fulfill the current level

        // add child nodes of the current level in the Queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      level++;  // go to next level
    }
    return levels;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}

