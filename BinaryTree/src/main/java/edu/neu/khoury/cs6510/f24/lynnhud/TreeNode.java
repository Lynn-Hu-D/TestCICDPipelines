package edu.neu.khoury.cs6510.f24.lynnhud;

import java.util.Objects;

/**
 * A TqreeNode has an value of integer, might have left child and right child.
 */
public class TreeNode {

  /**
   * The value of the tree node.
   */
  public Integer value;

  /**
   * The left node of the tree node.
   */
  public TreeNode left;

  /**
   * The right node of the tree node.
   */
  public TreeNode right;

  /** Constructor of a treeNode with value.
   *
   * @param value the value of the node
   */
  public TreeNode(Integer value) {
    this.value = value;
  }

  /**
   * Constructor of a treeNode with value, left and right node.
   *
   * @param value value of the tree node
   * @param left  the left child - a tree node
   * @param right the right child - a tree node
   */
  public TreeNode(Integer value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  /**
   * Convert the treenode to its string representation.
   *
   * @return a string representation of the treenode
   */
  @Override
  public String toString() {
    return "TreeNode{"
        + "value=" + value
        + ", left=" + left
        + ", right=" + right
        + '}';
  }

  /**
   * Check if the treeNode is equal to the object o.
   *
   * @param o object
   * @return if the TreeNode is equal to the object o
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNode treeNode)) {
      return false;
    }
    return Objects.equals(value, treeNode.value) && Objects.equals(left,
        treeNode.left) && Objects.equals(right, treeNode.right);
  }

  /**
   * Get the hashcode of the node.
   *
   * @return the hashcode of the TreeNode
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, left, right);
  }
}



