package net.licks92.wirelessredstone.network;

import static org.junit.Assert.*;
import net.licks92.wirelessredstone.network.io.OutputBehaviour;
import net.licks92.wirelessredstone.util.Position;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.States;
import org.junit.Before;
import org.junit.Test;

public class NetworkOutputTest {
    
    private NetworkOutput output;
    private Mockery context;
    
    @Before
    public void setUp() {
        this.context = new Mockery();
        this.output = new NetworkOutput(new Position(0, 0, 0, "world"), this.createDummyBehaviour());
    }

    private OutputBehaviour createDummyBehaviour() {
        final OutputBehaviour behaviour = this.context.mock(OutputBehaviour.class);
        final States outputting = context.states("outputting").startsAs("false");
        this.context.checking(new Expectations() {{
            allowing(behaviour).activate(); when(outputting.is("false")); then(outputting.is("true"));
            allowing(behaviour).deactivate(); when(outputting.is("true")); then(outputting.is("false"));
        }});
        return behaviour;
    }

    @Test
    public void testActivationDeactivation() {
        assertFalse(this.output.isActive());
        this.output.setIsActive(true);
        assertTrue(this.output.isActive());
        this.output.setIsActive(false);
        assertFalse(this.output.isActive());
    }
    
    @Test
    public void testDeactivationWhenInactive() {
        assertFalse(this.output.isActive());
        this.output.setIsActive(false);
        assertFalse(this.output.isActive());
    }
    
    @Test
    public void testActivationWhenActive() {
        this.output.setIsActive(true);
        assertTrue(this.output.isActive());
        this.output.setIsActive(true);
        assertTrue(this.output.isActive());
    }

}
