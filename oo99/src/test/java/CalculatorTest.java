import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(3, calculator.add(1, 2));
    }
    @org.junit.jupiter.api.Test
    void sub() {
        assertEquals(-1, calculator.sub(1, 2));
    }
    @org.junit.jupiter.api.Test
    void multi() {
        assertEquals(2, calculator.multi(1, 2));
    }
    @org.junit.jupiter.api.Test
    void div() {
        assertEquals(1, calculator.div(2, 2));
    }
}

