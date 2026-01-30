import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class UserRegistrationTest {
    UserRegistration registration;
    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }
    @Test
    void testValidUserRegistration() {
        assertTrue(
                registration.registerUser(
                        "john_doe",
                        "john@example.com",
                        "Password1"
                )
        );
    }
    @Test
    void testInvalidUsername() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "jo",
                        "john@example.com",
                        "Password1"
                )
        );
    }
    @Test
    void testInvalidEmail() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "john_doe",
                        "johnexample.com",
                        "Password1"
                )
        );
    }
    @Test
    void testInvalidPassword() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        "john_doe",
                        "john@example.com",
                        "pass"
                )
        );
    }
    @Test
    void testNullInputs() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registration.registerUser(
                        null,
                        null,
                        null
                )
        );
    }
}
