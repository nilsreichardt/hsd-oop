import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompTreeTest {

    private CompTree compTree;

    @BeforeEach
    public void setUp() throws Exception {
        compTree = new CompTree();
    }

    private void fillTreeWithMockData(CompTree tree) {
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
        assertEquals(true, compTree.isEmpty());
    }

    @Test
    @DisplayName(".isEmpty() should return false, if tree is not empty")
    public void testIsEmptyIfTreeIsNotEmpty() {
        assertEquals(true, compTree.isEmpty());
        compTree.add("Test");
        assertEquals(false, compTree.isEmpty());
    }

    @Test
    @DisplayName(".add() should set added node as root node, if tree is was empty")
    public void testIfRootNodeIsSetWhenFirstNodeIsAdded() {
        assertEquals(true, compTree.isEmpty());
        compTree.add("Test");
        assertEquals("Test", compTree.getRoot());
    }

    @Test
    @DisplayName(".add() should insert 6, 7, 2, 8, 9, 4, 1, 3, 5 correctly")
    public void testIfAddInsertCorrectly() {
        fillTreeWithMockData(compTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", compTree.toString());
    }

    @Test
    @DisplayName(".inorder() should returns tree in a 'inorder' way")
    public void testInorder() {
        fillTreeWithMockData(compTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", compTree.inorder());
    }

    @Test
    @DisplayName(".preorder() should returns tree in a 'preorder' way")
    public void testPreorder() {
        fillTreeWithMockData(compTree);
        assertEquals("6_2_1_4_3_5_7_8_9_", compTree.preorder());
    }

    @Test
    @DisplayName(".Postorder() should returns tree in a 'Postorder' way")
    public void testIfPostorder() {
        fillTreeWithMockData(compTree);
        assertEquals("1_3_5_4_2_9_8_7_6_", compTree.postorder());
    }

    @Test
    @DisplayName(".contains() should return false if searchingString is not in tree")
    public void testIfContainsReturnsFalseIfSearchingStringIsNotInTree() {
        assertEquals(false, compTree.contains("IsNotInTree"));
    }

    @Test
    @DisplayName(".contains() should return true if searchingString is in tree")
    public void testIfContainsReturnsTrueIfSearchingStringIsInTree() {
        fillTreeWithMockData(compTree);
        assertEquals(true, compTree.contains("6"));
        assertEquals(true, compTree.contains("7"));
        assertEquals(true, compTree.contains("2"));
        assertEquals(false, compTree.contains("A"));
        assertEquals(false, compTree.contains("10"));
    }

    @Test
    @DisplayName(".getSmallestPayload() should return the smallest payload")
    public void testGetSmallestPayload() {
        fillTreeWithMockData(compTree);
        assertEquals("1", compTree.getSmallestPayload());
    }

    @Test
    @DisplayName(".getBiggestPayload() should return the biggest payload")
    public void testGetBiggestPayload() {
        fillTreeWithMockData(compTree);
        assertEquals("9", compTree.getBiggestPayload());
    }

    @Test
    @DisplayName(".remove() should remove a payload from the tree")
    public void testRemove() {
        fillTreeWithMockData(compTree);
        compTree.remove("2");
        assertEquals("1_3_4_5_6_7_8_9_", compTree.toString());

        compTree.remove("8");
        assertEquals("1_3_4_5_6_7_9_", compTree.toString());

        compTree.remove("1");
        assertEquals("3_4_5_6_7_9_", compTree.toString());

        compTree.remove("4");
        assertEquals("3_5_6_7_9_", compTree.toString());

        compTree.remove("3");
        assertEquals("5_6_7_9_", compTree.toString());

        compTree.remove("5");
        assertEquals("6_7_9_", compTree.toString());

        compTree.remove("7");
        assertEquals("6_9_", compTree.toString());

        compTree.remove("9");
        assertEquals("6_", compTree.toString());

        compTree.remove("6");
        assertEquals("", compTree.toString());

        assertEquals(true, compTree.isEmpty());
    }

    @Test
    @DisplayName(".remove() should remove the root node correclty")
    public void testRemoveRoot() {
        // "fillTreeWithMockData" will fill the tree with 6 as root node.
        fillTreeWithMockData(compTree);

        compTree.remove("6");
        assertEquals("1_2_3_4_5_7_8_9_", compTree.toString());
        assertEquals("7", compTree.getRoot());
    }

    @Test
    @DisplayName(".paint() should paint tree correctly")
    public void testIfPaintWorksCorrectly() {
        fillTreeWithMockData(compTree);
        assertEquals("\t\t\t9\n\t\t8\n\t7\n6\n\t\t\t5\n\t\t4\n\t\t\t3\n\t2\n\t\t1\n", compTree.paint());
    }
}
