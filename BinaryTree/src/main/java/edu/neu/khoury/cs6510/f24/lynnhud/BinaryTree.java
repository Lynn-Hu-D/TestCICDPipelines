package edu.neu.khoury.cs6510.f24.lynnhud;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A binary tree class with methods for creating and verifying a binary search tree(BST).
 * finding maximum depth of the tree, getting the maximum value in the tree.
 */
public class BinaryTree {

  /**
   * The root of the binary tree.
   */
  public TreeNode root;

  /**
   * Constructor to create an empty binary tree.
   */
  public BinaryTree() {
    this.root = null;
  }

  /**
   * Create a Binary Search tree from a list of integers.
   *
   * @param values array of integers.
   */
  public void createBinaryTreeFromArray(int[] values) {
    if (values.length == 0) {
      return;
    }

    this.root = new TreeNode(values[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int i = 1;
    while (i < values.length) {
      TreeNode current = queue.poll();

      current.left = new TreeNode(values[i++]);
      queue.add(current.left);

      if (i < values.length) {
        current.right = new TreeNode(values[i++]);
        queue.add(current.right);
      }
    }
  }

  /**
   * A helper method to create a balanced binary tree from a sorted array of integers.
   *
   * @param values the sorted array of integers
   * @param start the start index of the current subarray
   * @param end the end index of the current subarray
   * @return the root of the balanced binary tree
   */
  private TreeNode createBalancedBinaryTree(int[] values, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(values[mid]);

    node.left = createBalancedBinaryTree(values, start, mid - 1);
    node.right = createBalancedBinaryTree(values, mid + 1, end);

    return node;
  }

  /**
   * Create a balanced binary tree from a sorted array of integers.
   *
   * @param values a sorted array of integers
   */
  public void createBalancedTreeFromSortedArray(int[] values) {
    this.root = createBalancedBinaryTree(values, 0, values.length - 1);
  }


  /**
   * A helper method that recursively check if the binary tree is BST.
   *
   * @param node a treeNode
   * @param lo the lower bound of the node values
   * @param hi the high bound of the node values
   * @return true if the node is a BST else false
   */
  private boolean isBstHelper(TreeNode node, Integer lo, Integer hi) {
    if (node == null) {
      return true;
    }
    if (node.value < lo || node.value > hi) {
      return false;
    }
    return isBstHelper(node.left, lo, node.value) && isBstHelper(node.right, node.value, hi);
  }

  /**
   * A method to check this binary tree is a BST or not.
   *
   * @return true if this binary tree is BST else false
   */
  public boolean isBst() {
    return isBstHelper(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * A helper method that recursively calculates the depth of the treeNode.
   *
   * @param node a treeNode
   * @return an integer represents the maximum depth of the treeNode
   */
  private Integer getMaxDepthHelper(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftDepth = getMaxDepthHelper(node.left);
    int rightDepth = getMaxDepthHelper(node.right);
    return 1 + Math.max(leftDepth, rightDepth);
  }

  /**
   * A method to get the maximum depth of the binary tree.
   *
   * @return an integer that represents the maximum depth of the binary tree
   */
  public Integer getMaxDepth() {
    return getMaxDepthHelper(this.root);
  }

  /**
   * A helper method that recursively finds the maximum value of a treeNode.
   *
   * @param node a treeNode
   * @return an integer that represents the maximum value in the treeNode
   */
  private Integer findMaxValueHelper(TreeNode node) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }
    int leftMax = findMaxValueHelper(node.left);
    int rightMax = findMaxValueHelper(node.right);
    return Math.max(node.value, Math.max(leftMax, rightMax));
  }

  /**
   * A method to find the maximum value inside the binary tree.
   *
   * @return an integer that represents the maximum value in the binary tree
   */
  public Integer findMaxValue() {
    return findMaxValueHelper(this.root);
  }
}
