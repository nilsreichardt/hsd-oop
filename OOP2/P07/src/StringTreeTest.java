import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTreeTest {

    private StringTree stringTree;

    @BeforeEach
    public void setUp() throws Exception {
        stringTree = new StringTree();
    }

    private void fillTreeWithMockData(StringTree tree) {
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
        assertEquals(true, stringTree.isEmpty());
    }

    @Test
    @DisplayName(".isEmpty() should return false, if tree is not empty")
    public void testIsEmptyIfTreeIsNotEmpty() {
        assertEquals(true, stringTree.isEmpty());
        stringTree.add("Test");
        assertEquals(false, stringTree.isEmpty());
    }

    @Test
    @DisplayName(".add() should set added node as root node, if tree is was empty")
    public void testIfRootNodeIsSetWhenFirstNodeIsAdded() {
        assertEquals(true, stringTree.isEmpty());
        stringTree.add("Test");
        assertEquals("Test", stringTree.getRoot());
    }

    @Test
    @DisplayName(".add() should insert 6, 7, 2, 8, 9, 4, 1, 3, 5 correctly")
    public void testIfAddInsertCorrectly() {
        fillTreeWithMockData(stringTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", stringTree.toString());
    }

    @Test
    @DisplayName(".inorder() should returns tree in a 'inorder' way")
    public void testInorder() {
        fillTreeWithMockData(stringTree);
        assertEquals("1_2_3_4_5_6_7_8_9_", stringTree.inorder());
    }

    @Test
    @DisplayName(".preorder() should returns tree in a 'preorder' way")
    public void testPreorder() {
        fillTreeWithMockData(stringTree);
        assertEquals("6_2_1_4_3_5_7_8_9_", stringTree.preorder());
    }

    @Test
    @DisplayName(".Postorder() should returns tree in a 'Postorder' way")
    public void testIfPostorder() {
        fillTreeWithMockData(stringTree);
        assertEquals("1_3_5_4_2_9_8_7_6_", stringTree.postorder());
    }

    @Test
    @DisplayName(".contains() should return false if searchingString is not in tree")
    public void testIfContainsReturnsFalseIfSearchingStringIsNotInTree() {
        assertEquals(false, stringTree.contains("IsNotInTree"));
    }

    @Test
    @DisplayName(".contains() should return true if searchingString is in tree")
    public void testIfContainsReturnsTrueIfSearchingStringIsInTree() {
        fillTreeWithMockData(stringTree);
        assertEquals(true, stringTree.contains("6"));
        assertEquals(true, stringTree.contains("7"));
        assertEquals(true, stringTree.contains("2"));
        assertEquals(false, stringTree.contains("A"));
        assertEquals(false, stringTree.contains("10"));
    }

    @Test
    @DisplayName(".getSmallestPayload() should return the smallest payload")
    public void testGetSmallestPayload() {
        fillTreeWithMockData(stringTree);
        assertEquals("1", stringTree.getSmallestPayload());
    }

    @Test
    @DisplayName(".getBiggestPayload() should return the biggest payload")
    public void testGetBiggestPayload() {
        fillTreeWithMockData(stringTree);
        assertEquals("9", stringTree.getBiggestPayload());
    }

    @Test
    @DisplayName(".remove() should remove a payload from the tree")
    public void testRemove() {
        fillTreeWithMockData(stringTree);
        stringTree.remove("2");
        assertEquals("1_3_4_5_6_7_8_9_", stringTree.toString());

        stringTree.remove("8");
        assertEquals("1_3_4_5_6_7_9_", stringTree.toString());

        stringTree.remove("1");
        assertEquals("3_4_5_6_7_9_", stringTree.toString());

        stringTree.remove("4");
        assertEquals("3_5_6_7_9_", stringTree.toString());

        stringTree.remove("3");
        assertEquals("5_6_7_9_", stringTree.toString());

        stringTree.remove("5");
        assertEquals("6_7_9_", stringTree.toString());

        stringTree.remove("7");
        assertEquals("6_9_", stringTree.toString());

        stringTree.remove("9");
        assertEquals("6_", stringTree.toString());
    }

    // Tests will be skipped, because this function is implemented yet.
    @Disabled
    @Test
    @DisplayName(".remove() should remove the root node correclty")
    public void testRemoveRoot() {
        // "fillTreeWithMockData" will fill the tree with 6 as root node.
        fillTreeWithMockData(stringTree);

        stringTree.remove("6");
        assertEquals("1_3_4_5_6_7_8_9_", stringTree.toString());

        // Note: Check also if stringTree.root is updated
    }

    @Test
    @DisplayName(".paint() should paint tree correctly")
    public void testIfPaintWorksCorrectly() {
        fillTreeWithMockData(stringTree);
        assertEquals("\t\t\t9\n\t\t8\n\t7\n6\n\t\t\t5\n\t\t4\n\t\t\t3\n\t2\n\t\t1\n", stringTree.paint());
    }
}
