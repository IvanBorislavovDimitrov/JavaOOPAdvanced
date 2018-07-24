package app.models;

import org.junit.Assert;
import org.junit.Test;

public class TestMethods {

    @Test
    public void test_mathAbs_worksCorrectly() {
        Assert.assertEquals(Math.abs(-111), 111);
    }

    @Test
    public void test_systemSeparator_worksCorrectly() {
        Assert.assertEquals(System.lineSeparator(), "\r\n");
    }

    @Test
    public void test_mathFloor_worksCorrectly() {
        Assert.assertEquals(Math.floor(111.13), 111, 0.1);
    }
}
