package app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTest {

    private ZonedDateTime zonedDateTime;

    @Before
    public void init() {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.JULY, 22, 14, 30);

        this.zonedDateTime = ldt.atZone(ZoneId.of("Europe/Sofia"));
    }

    @Test
    public void addDayToTheMiddleOfTheMonth() {
        this.zonedDateTime = this.zonedDateTime.plusDays(1);
        Assert.assertEquals(23, this.zonedDateTime.getDayOfMonth());
    }

    @Test
    public void addDayAndMonthChanges() {
        this.zonedDateTime = this.zonedDateTime.plusDays(10);
        Assert.assertEquals(1, this.zonedDateTime.getDayOfMonth());
        Assert.assertEquals(Month.AUGUST, this.zonedDateTime.getMonth());
    }

    @Test
    public void subtractDayAndMonthChanges() {
        this.zonedDateTime = this.zonedDateTime.plusDays(-22);
        Assert.assertEquals(30, this.zonedDateTime.getDayOfMonth());
        Assert.assertEquals(Month.JUNE, this.zonedDateTime.getMonth());
    }

    @Test
    public void addDayToALeapYear() {
        LocalDateTime ldt = LocalDateTime.of(2016, Month.FEBRUARY, 28, 14, 30);
        this.zonedDateTime = ldt.atZone(ZoneId.of("Europe/Sofia"));

        this.zonedDateTime = this.zonedDateTime.plusDays(1);
        Assert.assertEquals(29, this.zonedDateTime.getDayOfMonth());
        Assert.assertEquals(Month.FEBRUARY, this.zonedDateTime.getMonth());
    }

    @Test
    public void addDayToANonLeapYear() {
        LocalDateTime ldt = LocalDateTime.of(2018, Month.FEBRUARY, 28, 14, 30);
        this.zonedDateTime = ldt.atZone(ZoneId.of("Europe/Sofia"));

        this.zonedDateTime = this.zonedDateTime.plusDays(1);
        Assert.assertEquals(1, this.zonedDateTime.getDayOfMonth());
        Assert.assertEquals(Month.MARCH, this.zonedDateTime.getMonth());
    }
}
