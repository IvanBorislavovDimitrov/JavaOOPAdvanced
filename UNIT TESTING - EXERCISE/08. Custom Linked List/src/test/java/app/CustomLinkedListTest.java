package app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void init() {
        this.customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void add100Elements() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        Assert.assertEquals("Elements does not exist!", 99, this.customLinkedList.remove(99));
    }

    @Test
    public void deleteElements() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        this.customLinkedList.remove(50);

        Assert.assertFalse(this.customLinkedList.contains(50));
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        this.customLinkedList.remove(50);

        Assert.assertEquals(java.util.Optional.of(99).get(), this.customLinkedList.get(98));
    }

    @Test
    public void testSet() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        this.customLinkedList.set(0, 123);

        Integer expected = 123;
        Assert.assertEquals("Element not set", expected, this.customLinkedList.get(0));
    }

    @Test
    public void testRemoveAt() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        this.customLinkedList.removeAt(0);

        Integer expected = 1;
        Assert.assertEquals("Element are not the same", expected, this.customLinkedList.get(0));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 100; i++) {
            this.customLinkedList.add(i);
        }

        Integer expected = 99;
        Integer real = this.customLinkedList.indexOf(99);
        Assert.assertEquals("Element are not the same", expected, real);
    }
}
