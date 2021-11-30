package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    @Test
    public void testAlarmOn(){
        Sensor mock = Mockito.mock(Sensor.class);
        Mockito.when(mock.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(mock);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOff(){
        Sensor mock = Mockito.mock(Sensor.class);
        Mockito.when(mock.popNextPressurePsiValue()).thenReturn(18.0);
        Alarm alarm = new Alarm(mock);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}