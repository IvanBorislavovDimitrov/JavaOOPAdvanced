package bg.softuni.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTimeTests {

    @Test
    public void testToString() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 25/02/2016");

        Assert.assertEquals("12:24 25/02/2016", registrationTime.toString());
    }

    @Test
    public void fullDateTest() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 25/02/2016");

        Assert.assertEquals(Integer.valueOf(12), registrationTime.getHour());
        Assert.assertEquals(Integer.valueOf(24), registrationTime.getMinutes());
        Assert.assertEquals(Integer.valueOf(25), registrationTime.getDay());
        Assert.assertEquals(Integer.valueOf(2), registrationTime.getMonth());
        Assert.assertEquals(Integer.valueOf(2016), registrationTime.getYear());
    }

    @Test
    public void testDay() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 28/02/2016");
        Assert.assertEquals(Integer.valueOf(28), registrationTime.getDay());
    }

    @Test
    public void testMonth() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 28/02/2016");
        Assert.assertEquals(Integer.valueOf(2), registrationTime.getMonth());
    }

    @Test
    public void testYear() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 28/02/2016");
        Assert.assertEquals(Integer.valueOf(2016), registrationTime.getYear());
    }

    @Test
    public void testHour() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 28/02/2016");
        Assert.assertEquals(Integer.valueOf(12), registrationTime.getHour());
    }

    @Test
    public void testMinutes() {
        RegistrationTime registrationTime = new RegistrationTime("12:24 28/02/2016");
        Assert.assertEquals(Integer.valueOf(24), registrationTime.getMinutes());
    }
}
