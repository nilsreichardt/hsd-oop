import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DoLiStringTest {
    private DoLiString doLiString;

    @BeforeEach
    public void setUp() throws Exception {
        doLiString = new DoLiString();
    }

    @Test
    @DisplayName("first be null if list is empty")
    public void testFirstIsNullEmptyIfListEmpty() {
        assertEquals(doLiString.getFirst(), null);
    }
}
