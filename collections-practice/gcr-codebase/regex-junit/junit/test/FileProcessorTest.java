import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileProcessorTest {
    FileProcessor fileProcessor;
    String fileName = "testFile.txt";
    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }
    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Path.of(fileName));
    }
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Test";
        fileProcessor.writeToFile(fileName, content);
        String result = fileProcessor.readFromFile(fileName);
        assertEquals(content, result);
    }
    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(fileName, "Test Data");
        assertTrue(Files.exists(Path.of(fileName)));
    }
    @Test
    void testReadFileNotExists() {
        assertThrows(
                IOException.class,
                () -> fileProcessor.readFromFile("noFile.txt")
        );
    }
}
