import org.junit.*;

import static org.junit.Assert.*;

public class TestCustomList {

    @Test
    public void testMaxElement() {
        CustomList<Integer> customList = new CustomList<>();
        for (int i = 0; i < 100; i++) {
            customList.add(i);
        }

        Integer expected = 99;
        assertEquals(expected, customList.getMax());
    }

    @Test
    public void testMinElement() {
        CustomList<Integer> customList = new CustomList<>();
        Integer expected = -1000;
        for (int i = -1000; i <= 10000; i++) {
            customList.add(i);
        }

        assertEquals(expected, customList.getMin());
    }

    @Test
    public void removeElements() {
        CustomList<Integer> customList = new CustomList<>();
        Integer expected = 10000;
        for (int i = 0; i <= 10000; i++) {
            customList.add(i);
        }

        for (int i = 0; i <= 500; i++) {
            customList.remove(i);
        }

        assertEquals(expected, customList.getMax());
    }

    @Test
    public void contains() {
        CustomList<Integer> customList = new CustomList<>();
        for (int i = 0; i <= 10000; i++) {
            customList.add(i);
        }

        assertFalse(customList.contains(113144));
    }
}
