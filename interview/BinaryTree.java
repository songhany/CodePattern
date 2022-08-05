package interview;

import java.util.*;

public class BinaryTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
  }

  TreeNode root;

  public TreeNode constructTree(Integer[] levelOrderArray) {
    TreeNode root = null;
    for (int i = 0; i < levelOrderArray.length; i++) {
      if (levelOrderArray[i] == null) {
        continue;
      }
      root = insert(root, levelOrderArray[i]);
    }
    return root;
  }

  public List<Integer> destructTree(TreeNode root) {
    // Bread First Search (level order traversal)
    List<Integer> treeInOrderArray = new ArrayList<>();
    if (root == null) return treeInOrderArray;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int curLevelSize = queue.size();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode cur = queue.poll();
        treeInOrderArray.add(cur.val);
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
    }
    return treeInOrderArray;
  }

  public TreeNode insert(TreeNode root, Integer target) {
    if (root == null) {
      return new TreeNode(target);
    }

    if (root.val < target) {
      root.right = insert(root.right, target);
    } else if (root.val > target) {
      root.left = insert(root.left, target);
    }
    return root;
  }

  public static void main(String[] args) {
    BinaryTree sol = new BinaryTree();
  
    Integer[] array = new Integer[]{8, 2, 98, null, 18, 1, 100};
    TreeNode root = sol.constructTree(array);
    sol.inOrderTraversal(root);
    System.out.println(sol.destructTree(root));
    // getHeight(root);
  }

  public void inOrderTraversal(TreeNode root) {
    if (root == null) return;

    inOrderTraversal(root.left);
    System.out.println(root.val);
    inOrderTraversal(root.right);
  }
}
