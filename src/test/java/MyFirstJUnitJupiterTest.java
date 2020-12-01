import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyFirstJUnitJupiterTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void create() {
        Calculator cal = new Calculator();
        assertNotNull(cal);
    }

    @DisplayName("기본 테스트")
    @Test
    void test() {
        String name = "keesun";
        assertEquals("keesun", name, () -> "name is not " + name);
    }
}