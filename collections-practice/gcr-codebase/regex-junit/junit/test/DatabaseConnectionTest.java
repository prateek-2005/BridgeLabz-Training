import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class DatabaseConnectionTest {
    DatabaseConnection db;
    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }
    @AfterEach
    void tearDown() {
        db.disconnect();
    }
    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected");
    }
    @Test
    void testConnectionStillActiveDuringTest() {
        assertTrue(db.isConnected());
    }
}
