import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringUtilsTest {
    StringUtils utils = new StringUtils();
    @Test
    public void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
        assertEquals("avaJ", utils.reverse("Java"));
        assertEquals("", utils.reverse(""));
    }
    @Test
    public void testReverseNull() {
        assertNull(utils.reverse(null));
    }
    @Test
    public void testIsPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("level"));
    }

    @Test
    public void testIsPalindromeFalse() {
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome("java"));
    }

    @Test
    public void testIsPalindromeNull() {
        assertFalse(utils.isPalindrome(null));
    }
    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("Java"));
        assertEquals("123", utils.toUpperCase("123"));
    }

    @Test
    public void testToUpperCaseNull() {
        assertNull(utils.toUpperCase(null));
    }
}
