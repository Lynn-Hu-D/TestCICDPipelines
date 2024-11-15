package edu.neu.khoury.cs6510.f24.lynnhud;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void createBinaryTreeFromArrayTest() {
        // Test with multiple values
        int[] values = {10, 5, 15, 3, 7, 12};
        binaryTree.createBinaryTreeFromArray(values);

        assertEquals(10, binaryTree.root.value);
        assertEquals(5, binaryTree.root.left.value);
        assertEquals(15, binaryTree.root.right.value);
        assertEquals(3, binaryTree.root.left.left.value);
        assertEquals(7, binaryTree.root.left.right.value);
        assertEquals(12, binaryTree.root.right.left.value);

        // Test with single value
        binaryTree = new BinaryTree();
        int[] singleValue = {42};
        binaryTree.createBinaryTreeFromArray(singleValue);
        assertEquals(42, binaryTree.root.value);
        assertNull(binaryTree.root.left);
        assertNull(binaryTree.root.right);

        // Test with empty array
        binaryTree = new BinaryTree();
        int[] emptyValues = {};
        binaryTree.createBinaryTreeFromArray(emptyValues);
        assertNull(binaryTree.root);

        // Test with duplicate values
        binaryTree = new BinaryTree();
        int[] duplicateValues = {10, 10, 10};
        binaryTree.createBinaryTreeFromArray(duplicateValues);
        assertEquals(10, binaryTree.root.value);
        assertEquals(10, binaryTree.root.left.value);
        assertEquals(10, binaryTree.root.right.value);
    }

    @Test
    void createBalancedTreeFromSortedArrayTest() {
        int[] sortedValues = {3, 5, 7, 10, 12, 15, 17};
        binaryTree.createBalancedTreeFromSortedArray(sortedValues);

        assertEquals(10, binaryTree.root.value);
        assertEquals(5, binaryTree.root.left.value);
        assertEquals(15, binaryTree.root.right.value);
        assertEquals(3, binaryTree.root.left.left.value);
        assertEquals(7, binaryTree.root.left.right.value);
        assertEquals(12, binaryTree.root.right.left.value);
        assertEquals(17, binaryTree.root.right.right.value);
    }

    @Test
    void isBstTest() {
        // Valid BST
        int[] bstValues = {10, 5, 15, 3, 7, 12, 17};
        binaryTree.createBinaryTreeFromArray(bstValues);
        assertTrue(binaryTree.isBst());

        // Non-BST: Left child greater than parent (node.value < lo)
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(5);
        binaryTree.root = root;
        assertFalse(binaryTree.isBst());

        // Non-BST: Right child smaller than parent (node.value > hi)
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        binaryTree.root = root;
        assertFalse(binaryTree.isBst());

        // Edge case: Single node tree
        binaryTree = new BinaryTree();
        int[] singleValue = {42};
        binaryTree.createBinaryTreeFromArray(singleValue);
        assertTrue(binaryTree.isBst());

        // Edge case: Empty tree
        binaryTree = new BinaryTree();
        assertTrue(binaryTree.isBst());
    }

    @Test
    void getMaxDepthTest() {
        int[] values = {10, 5, 15, 3, 7, 12, 17};
        binaryTree.createBinaryTreeFromArray(values);
        assertEquals(3, binaryTree.getMaxDepth());

        binaryTree = new BinaryTree();
        assertEquals(0, binaryTree.getMaxDepth());
    }

    @Test
    void findMaxValueTest() {
        int[] values = {10, 5, 15, 3, 7, 12, 17};
        binaryTree.createBinaryTreeFromArray(values);
        assertEquals(17, binaryTree.findMaxValue());

        int[] sortedValues = {3, 5, 7, 10, 12, 15, 17};
        binaryTree.createBalancedTreeFromSortedArray(sortedValues);
        assertEquals(17, binaryTree.findMaxValue());

        binaryTree = new BinaryTree();
        assertEquals(Integer.MIN_VALUE, binaryTree.findMaxValue());
    }
}