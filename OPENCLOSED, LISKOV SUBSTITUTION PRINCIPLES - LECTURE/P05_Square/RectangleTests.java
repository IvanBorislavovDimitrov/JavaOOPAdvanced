package app.P05_Square;


import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {

    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(5, 10);
        Assert.assertEquals(5, rect.getWidth());
        Assert.assertEquals(10, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5, 10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void testAreaSquare() {
        Rectangle square = new Square(5);
        Assert.assertEquals(25, square.getArea());
    }
}
