import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenCompTreeTest {

    private GenCompTree<String> genCompTree;

    @BeforeEach
    public void setUp() {
        genCompTree = new GenCompTree<>();
    }

    private void fillTreeWithMockData(GenCompTree<String> tree) {
        tree.add("6");
        tree.add("7");
        tree.add("2");
        tree.add("8");
        tree.add("9");
        tree.add("4");
        tree.add("1");
        tree.add("3");
        tree.add("5");
    }

    @Test
    @DisplayName(".isEmpty() should return true, if tree is empty")
    public void testIsEmptyIfTreeIsEmpty() {
        assertTrue(genCompTree.isEmpty());
    }

    @Test
    @DisplayName(".isEmpty() should return false, if tree is not empty")
    public void testIsEmptyIfTreeIsNotEmpty() {
        assertTrue(genCompTree.isEmpty());
        genCompTree.add("Test");
        assertFalse(genCompTree.isEmpty());
    }

    @Test
    @DisplayName(".add() should set added node as root node, if tree is was empty")
    public void testIfRootNodeIsSetWhenFirstNodeIsAdded() {
        assertTrue(genCompTree.isEmpty());
        genCompTree.add("Test");
        assertEquals("Test", genCompTree.getRoot());
    }

    @Test
    @DisplayName(".add() should insert 6, 7, 2, 8, 9, 4, 1, 3, 5 correctly")
    public void testIfAddInsertCorrectly() {
        fillTreeWithMockData(genCompTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", genCompTree.toString());
    }

    @Test
    @DisplayName(".inorder() should returns tree in a 'inorder' way")
    public void testInorder() {
        fillTreeWithMockData(genCompTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", genCompTree.inorder());
    }

    @Test
    @DisplayName(".preorder() should returns tree in a 'preorder' way")
    public void testPreorder() {
        fillTreeWithMockData(genCompTree);
        assertEquals("6_2_1_4_3_5_7_8_9_", genCompTree.preorder());
    }

    @Test
    @DisplayName(".Postorder() should returns tree in a 'Postorder' way")
    public void testIfPostorder() {
        fillTreeWithMockData(genCompTree);
        assertEquals("1_3_5_4_2_9_8_7_6_", genCompTree.postorder());
    }

    @Test
    @DisplayName(".contains() should return false if searchingString is not in tree")
    public void testIfContainsReturnsFalseIfSearchingStringIsNotInTree() {
        assertFalse(genCompTree.contains("IsNotInTree"));
    }

    @Test
    @DisplayName(".contains() should return true if searchingString is in tree")
    public void testIfContainsReturnsTrueIfSearchingStringIsInTree() {
        fillTreeWithMockData(genCompTree);
        assertTrue(genCompTree.contains("6"));
        assertTrue(genCompTree.contains("7"));
        assertTrue(genCompTree.contains("2"));
        assertFalse(genCompTree.contains("A"));
        assertFalse(genCompTree.contains("10"));
    }

    @Test
    @DisplayName(".getSmallestPayload() should return the smallest payload")
    public void testGetSmallestPayload() {
        fillTreeWithMockData(genCompTree);
        assertEquals("1", genCompTree.getSmallestPayload());
    }

    @Test
    @DisplayName(".getBiggestPayload() should return the biggest payload")
    public void testGetBiggestPayload() {
        fillTreeWithMockData(genCompTree);
        assertEquals("9", genCompTree.getBiggestPayload());
    }

    @Test
    @DisplayName(".remove() should remove a payload from the tree")
    public void testRemove() {
        fillTreeWithMockData(genCompTree);
        genCompTree.remove("2");
        assertEquals("1_3_4_5_6_7_8_9_", genCompTree.toString());

        genCompTree.remove("8");
        assertEquals("1_3_4_5_6_7_9_", genCompTree.toString());

        genCompTree.remove("1");
        assertEquals("3_4_5_6_7_9_", genCompTree.toString());

        genCompTree.remove("4");
        assertEquals("3_5_6_7_9_", genCompTree.toString());

        genCompTree.remove("3");
        assertEquals("5_6_7_9_", genCompTree.toString());

        genCompTree.remove("5");
        assertEquals("6_7_9_", genCompTree.toString());

        genCompTree.remove("7");
        assertEquals("6_9_", genCompTree.toString());

        genCompTree.remove("9");
        assertEquals("6_", genCompTree.toString());

        genCompTree.remove("6");
        assertEquals("", genCompTree.toString());

        assertTrue(genCompTree.isEmpty());
    }

    @Test
    @DisplayName(".remove() should remove the root node correclty")
    public void testRemoveRoot() {
        // "fillTreeWithMockData" will fill the tree with 6 as root node.
        fillTreeWithMockData(genCompTree);

        genCompTree.remove("6");
        assertEquals("1_2_3_4_5_7_8_9_", genCompTree.toString());
        assertEquals("7", genCompTree.getRoot());
    }

    @Test
    @DisplayName(".paint() should paint tree correctly")
    public void testIfPaintWorksCorrectly() {
        fillTreeWithMockData(genCompTree);
        assertEquals("\t\t\t9\n\t\t8\n\t7\n6\n\t\t\t5\n\t\t4\n\t\t\t3\n\t2\n\t\t1\n", genCompTree.paint());
    }
}
