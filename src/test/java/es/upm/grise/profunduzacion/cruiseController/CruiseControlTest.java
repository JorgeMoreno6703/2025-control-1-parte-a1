package es.upm.grise.profunduzacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
class CruiseControlTest {
    @Mock
    private Speedometer speedometer;

    private CruiseControl cruiseControl;

    @BeforeEach
    void setUp() {
        cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(120);
    }

    @Test
    void testSetSpeedSetWithinLimit() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException{
        when(speedometer.getCurrentSpeed()).thenReturn(80);
        cruiseControl.setSpeedSet(100);
        assertEquals(100, cruiseControl.getSpeedSet());
    }

    @Test
    void testSetSpeedSetAboveLimitThrowsException() {
        when(speedometer.getCurrentSpeed()).thenReturn(90);
        assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {
            cruiseControl.setSpeedSet(130);
        });
    }

    @Test
    void testSetSpeedSetBelowCurrentSpeedThrowsException() {
        when(speedometer.getCurrentSpeed()).thenReturn(90);
        assertThrows(IncorrectSpeedException.class, () -> {
            cruiseControl.setSpeedSet(70);
        });
    }
}
