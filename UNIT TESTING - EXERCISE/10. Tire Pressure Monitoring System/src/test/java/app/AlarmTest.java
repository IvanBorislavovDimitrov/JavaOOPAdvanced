package app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class AlarmTest {

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void init() {
        this.alarm = new Alarm();
        this.sensor = Mockito.mock(Sensor.class);
    }

    @Test
    public void testAlarmTurningOn() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(3.0);
        Field sensor = this.alarm.getClass().getDeclaredField("sensor");
        sensor.setAccessible(true);
        sensor.set(this.alarm, this.sensor);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void testAlarmTurningOff() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(18D);
        Field sensor = this.alarm.getClass().getDeclaredField("sensor");
        sensor.setAccessible(true);
        sensor.set(this.alarm, this.sensor);
        this.alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());
    }
}
