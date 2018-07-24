package app;

import app.ListIteratorImpl;
import org.junit.Assert;
import org.junit.Before;

import app.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class ListIteratorTest {

    private ListIterator<String> listIterator;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initListIterator() {
        this.listIterator = new ListIteratorImpl<>("Pesho", "Mitko", "Gogo");
    }

    @Test
    public void listIterator_testMove_expectedMoveByOne() throws OperationNotSupportedException {
        this.listIterator.move();
        Assert.assertEquals("Mitko", this.listIterator.print());
    }

    @Test
    public void listIterator_testMove_expectedMoveByOneIndex() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        this.listIterator.move();
        Field index = this.listIterator.getClass().getDeclaredField("index");
        index.setAccessible(true);
        Assert.assertEquals(1, index.get(this.listIterator));
    }

    @Test
    public void listIterator_testHasMove_expectedTrue() {
        this.listIterator.move();
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void listIterator_testHasMove_expectedFalse() {
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.hasNext());
    }


    @Test
    public void listIterator_testPrint_expectLastString() throws OperationNotSupportedException {
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();

        Assert.assertEquals("Gogo", this.listIterator.print());
    }

    @Test
    public void listIterator_testPrint_expectedException() throws OperationNotSupportedException {
        ListIterator<Integer> s = new ListIteratorImpl<>();
        expectedException.expect(OperationNotSupportedException.class);
        expectedException.expectMessage("Invalid Operation!");
        s.print();
    }
}
