package net.licks92.wirelessredstone.network;

import static org.junit.Assert.*;
import net.licks92.wirelessredstone.network.io.InputSource;
import net.licks92.wirelessredstone.util.Position;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.States;
import org.junit.Before;
import org.junit.Test;

public class NetworkInputTest {
    
    private Mockery context;
    private InputSource activatedInput;
    private InputSource deactivatedInput;
    private InputSource alternatingInput;
    private Position position;

    @Before
    public void setUp() throws Exception {
        this.context = new Mockery();
        final InputSource activated = this.context.mock(InputSource.class, "activated");
        final InputSource deactivated = this.context.mock(InputSource.class, "deactivated");
        final InputSource alternating = this.context.mock(InputSource.class, "alternating");
        final States alternatingState = this.context.states("alternating").startsAs("off");
        this.context.checking(new Expectations() {{
            allowing(activated).hasInputSignal(); will(returnValue(true));
            allowing(deactivated).hasInputSignal(); will(returnValue(false));
            allowing(alternating).hasInputSignal(); when(alternatingState.is("off")); will(returnValue(false)); then(alternatingState.is("on"));
            allowing(alternating).hasInputSignal(); when(alternatingState.is("on")); will(returnValue(true)); then(alternatingState.is("off"));
        }});
        this.activatedInput = activated;
        this.deactivatedInput = deactivated;
        this.alternatingInput = alternating;
        this.position = new Position(0, 0, 0, "world");
    }

    @Test
    public void testActivated() {
        NetworkInput input = new NetworkInput(this.position, this.activatedInput);
        for (int i = 0; i < 10; i++) {
            assertTrue(input.hasInputSignal());
        }
    }
    
    @Test
    public void testDeactivated() {
        NetworkInput input = new NetworkInput(this.position, this.deactivatedInput);
        for (int i = 0; i < 10; i++) {
            assertFalse(input.hasInputSignal());
        }
    }
    
    @Test
    public void testAlternating() {
        NetworkInput input = new NetworkInput(this.position, this.alternatingInput);
        for (int i = 0; i < 10; i++) {
            assertFalse(input.hasInputSignal());
            assertTrue(input.hasInputSignal());
        }
    }

}
