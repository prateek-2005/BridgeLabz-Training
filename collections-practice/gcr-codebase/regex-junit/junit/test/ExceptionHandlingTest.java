import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExceptionHandlingTest {
    @Test
    void testDivideByZeroException() {
    	ExceptionHandling calculator = new ExceptionHandling();

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testDivideSuccessfully() {
    	ExceptionHandling calculator = new ExceptionHandling();
        assertEquals(5, calculator.divide(10, 2));
    }
}