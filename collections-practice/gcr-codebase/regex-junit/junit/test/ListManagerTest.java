import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
public class ListManagerTest {
    private ListManager manager;
    private List<Integer> list;
    @BeforeEach
    void setUp() {
        manager = new ListManager();
        list = new ArrayList<>();
    }
    @Test
    void testAddElement() {
        manager.addElement(list, 10);
        manager.addElement(list, 20);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, manager.getSize(list));
    }
    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);
        list.add(30);
        manager.removeElement(list, 20);
        assertFalse(list.contains(20));
        assertEquals(2, manager.getSize(list));
    }
    @Test
    void testGetSize() {
        assertEquals(0, manager.getSize(list));
        manager.addElement(list, 5);
        manager.addElement(list, 15);
        assertEquals(2, manager.getSize(list));
    }
}
