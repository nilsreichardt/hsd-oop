import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTreeTest {

    private StringTree stringTree;

    @BeforeEach
    public void setUp() throws Exception {
        stringTree = new StringTree();
    }

    @Test
    @DisplayName(".isEmpty should return true, if tree is empty")
    public void testIsEmptyIfTreeIsEmpty() {
        assertEquals(true, stringTree.isEmpty());
    }

    @Test
    @DisplayName(".isEmpty should return false, if tree is not empty")
    public void testIsEmptyIfTreeIsNotEmpty() {
        assertEquals(false, stringTree.isEmpty());
    }

}
