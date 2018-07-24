package app;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleTest {

    @Test
    public void bubble_test5Elements_ordered() {
        Integer[] elements = {4, 3, 2, 1, 0};
        Bubble.sort(elements);

        Integer[] expected = {0, 1, 2, 3, 4};

        Assert.assertArrayEquals("Bubble sort doesn't work", expected, elements);
    }

    @Test
    public void bubble_test500Elements_ordered() {
        Integer[] elements = new Integer[500];
        Random random = new Random();
        Integer[] expected = new Integer[500];

        for (int i = 0; i < elements.length; i++) {
            int rnd = random.nextInt(4000000);
            elements[i] = rnd;
            expected[i] = rnd;
        }

        Bubble.sort(elements);
        Arrays.sort(expected);

        Assert.assertArrayEquals("Bubble sort doesn't work", expected, elements);
    }
}
