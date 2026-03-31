import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() { 
    	assertEquals(10, calc.add(7,3));
    }
    @Test
    public void testSubtract() { 
    	assertEquals(4, calc.subtract(7,3)); 
    }
    @Test
    public void testMultiply() {
    	assertEquals(21, calc.multiply(7,3));
    }
    @Test
    public void testDivide() { 
    	assertEquals(5, calc.divide(10,2)); 
    }
    @Test
    public void testDivideByZero() {
        Exception e = assertThrows(ArithmeticException.class, () -> calc.divide(10,0));
        assertEquals("Cannot divide by zero!", e.getMessage());
    }
}
