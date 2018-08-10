package bg.softuni.models.collection;

import bg.contracts.Fragment;
import bg.contracts.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LStackTests {

    private Stack<Fragment> fragmentStack;

    @Before
    public void setUp() throws Exception {
        fragmentStack = new LStack<>();
    }

    @Test
    public void size() {
        Fragment fragment1 = Mockito.mock(Fragment.class);
        Fragment fragment2 = Mockito.mock(Fragment.class);
        Fragment fragment3 = Mockito.mock(Fragment.class);
        fragmentStack.push(fragment1);
        fragmentStack.push(fragment2);
        fragmentStack.push(fragment3);

        Assert.assertEquals(Integer.valueOf(3), fragmentStack.size());
    }

    @Test
    public void push() {
        Fragment fragment1 = Mockito.mock(Fragment.class);
        fragmentStack.push(fragment1);

        Assert.assertEquals(Integer.valueOf(1), fragmentStack.size());
    }

    @Test
    public void pop() {
        Fragment fragment1 = Mockito.mock(Fragment.class);

        fragmentStack.push(fragment1);

        Fragment same = fragmentStack.pop();

        Assert.assertEquals(fragment1, same);
    }

    @Test
    public void peek() {
        Fragment fragment1 = Mockito.mock(Fragment.class);

        fragmentStack.push(fragment1);

        Fragment same = fragmentStack.peek();

        Assert.assertEquals(fragment1, same);
    }

    @Test
    public void isEmpty() {
        Fragment fragment1 = Mockito.mock(Fragment.class);
        Fragment fragment2 = Mockito.mock(Fragment.class);
        Fragment fragment3 = Mockito.mock(Fragment.class);
        fragmentStack.push(fragment1);
        fragmentStack.push(fragment2);
        fragmentStack.push(fragment3);

        fragmentStack.pop();
        fragmentStack.pop();
        fragmentStack.pop();

        Assert.assertTrue(fragmentStack.isEmpty());
    }

}
