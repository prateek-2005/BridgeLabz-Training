import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class PasswordValidatorTest {
    PasswordValidator validator;
    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }
    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Ab1"));
    }
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
