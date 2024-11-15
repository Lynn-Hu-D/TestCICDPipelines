package edu.neu.khoury.cs6510.f24.lynnhud;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    private TreeNode node1;
    private TreeNode node2;

    @BeforeEach
    void setUp() {
        node1 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        node2 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
    }

    @Test
    public void testConstructorWithValue() {
        TreeNode node = new TreeNode(10);
        assertNotNull(node);
        assertEquals(10, node.value);
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testConstructorWithValueLeftRight() {
        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(15);
        TreeNode node = new TreeNode(10, leftNode, rightNode);

        assertNotNull(node);
        assertEquals(10, node.value);
        assertEquals(leftNode, node.left);
        assertEquals(rightNode, node.right);
    }

    @Test
    public void testToString() {
        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(15);
        TreeNode node = new TreeNode(10, leftNode, rightNode);

        String expectedString = "TreeNode{value=10, left=TreeNode{value=5, left=null, right=null}, right=TreeNode{value=15, left=null, right=null}}";
        assertEquals(expectedString, node.toString());
    }
    @Test
    void equalsSameObject() {
        assertTrue(node1.equals(node1));
    }

    @Test
    void equalsDifferentClass() {
        // Test where 'o' is not an instance of TreeNode
        assertFalse(node1.equals("someString"));
        assertFalse(node1.equals(null));
    }

    @Test
    void equalsSameValues() {
        // Test where both nodes have the same values for value, left, and right
        assertTrue(node1.equals(node2));
    }

    @Test
    void equalsDifferentValues() {
        // Test where 'value' is different
        TreeNode differentValueNode = new TreeNode(20, new TreeNode(5), new TreeNode(15));
        assertFalse(node1.equals(differentValueNode));
    }

    @Test
    void equalsDifferentLeftChild() {
        // Test where 'left' is different
        TreeNode differentLeftChild = new TreeNode(10, new TreeNode(3), new TreeNode(15));
        assertFalse(node1.equals(differentLeftChild));
    }

    @Test
    void equalsDifferentRightChild() {
        // Test where 'right' is different
        TreeNode differentRightChild = new TreeNode(10, new TreeNode(5), new TreeNode(20));
        assertFalse(node1.equals(differentRightChild));
    }

    @Test
    void equalsNullLeftRightChildren() {
        // Test where both left and right children are null
        TreeNode noChildrenNode1 = new TreeNode(10, null, null);
        TreeNode noChildrenNode2 = new TreeNode(10, null, null);
        assertTrue(noChildrenNode1.equals(noChildrenNode2));

        // Test case where one has null left child and the other doesn't
        TreeNode nodeWithLeftChild = new TreeNode(10, new TreeNode(5), null);
        assertFalse(noChildrenNode1.equals(nodeWithLeftChild));
    }
    @Test
    public void testHashCodeEqualNodes() {
        TreeNode node1 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        TreeNode node2 = new TreeNode(10, new TreeNode(5), new TreeNode(15));

        assertEquals(node1.hashCode(), node2.hashCode());
    }

    @Test
    public void testHashCodeDifferentNodes() {
        TreeNode node1 = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        TreeNode node2 = new TreeNode(20, new TreeNode(5), new TreeNode(15));

        assertNotEquals(node1.hashCode(), node2.hashCode());
    }
}
