package net.licks92.wirelessredstone.network;

import static org.junit.Assert.*;
import net.licks92.wirelessredstone.network.io.InputSource;
import net.licks92.wirelessredstone.network.io.OutputBehaviour;
import net.licks92.wirelessredstone.util.Position;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class WirelessChannelTest {
    
    private Mockery context;
    private NetworkInput activatedInput;
    private NetworkInput deactivatedInput;
    private NetworkOutput output;
    
    private WirelessChannel channel;

    @Before
    public void setUp() {
        this.context = new Mockery();
        this.channel = new WirelessChannel("Test");
        this.prepareInputSources();
    }

    private void prepareInputSources() {
        final InputSource activatedInputSource = this.context.mock(InputSource.class, "activeInput");
        final InputSource deactivatedInputSource = this.context.mock(InputSource.class, "inactiveInput");
        final OutputBehaviour outputBehaviour = this.context.mock(OutputBehaviour.class, "output");
        Position pos = new Position(0, 0, 0, "world");
        this.context.checking(new Expectations() {{
            allowing(activatedInputSource).hasInputSignal(); will(returnValue(true));
            allowing(deactivatedInputSource).hasInputSignal(); will(returnValue(false));
            allowing(outputBehaviour).activate();
            allowing(outputBehaviour).deactivate();
        }});
        this.activatedInput = new NetworkInput(pos, activatedInputSource);
        this.deactivatedInput = new NetworkInput(pos, deactivatedInputSource);
        this.output = new NetworkOutput(pos, outputBehaviour);
    }

    @Test
    public void testGetName() {
        assertEquals("Test", this.channel.getName());
    }
    
    @Test
    public void testEmptyChannel() {
        this.channel.update(); // Mustn't throw errors
        assertFalse(this.channel.isActive());
        assertTrue(this.channel.getAllElements().isEmpty());
        assertTrue(this.channel.getInputs().isEmpty());
        assertTrue(this.channel.getOutputs().isEmpty());
    }
    
    @Test
    public void testAddedInput() {
        this.channel.addElement(this.deactivatedInput);
        assertTrue(this.channel.getAllElements().contains(this.deactivatedInput));
        assertTrue(this.channel.getInputs().contains(this.deactivatedInput));
        assertTrue(this.channel.getOutputs().isEmpty());
        assertFalse(this.channel.isActive());
    }
    
    @Test
    public void testAddedOutput() {
        this.channel.addElement(this.output);
        assertTrue(this.channel.getAllElements().contains(this.output));
        assertTrue(this.channel.getInputs().isEmpty());
        assertTrue(this.channel.getOutputs().contains(this.output));
        assertFalse(this.output.isActive());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testExceptionOnAddingWrongElementType() {
        this.channel.addElement(new NetworkElement(new Position(0, 0, 0, "Test")));
    }

    @Test
    public void testAddingActiveInputActivatesChannel() {
        assertFalse(this.channel.isActive());
        this.channel.addElement(this.activatedInput);
        assertTrue(this.channel.isActive());
    }
    
    @Test
    public void testOutputIsActivatedIfAddedToActiveChannel() {
        this.channel.addElement(this.activatedInput);
        assertTrue(this.channel.isActive());
        assertFalse(this.output.isActive());
        this.channel.addElement(this.output);
        assertTrue(this.channel.isActive());
        assertTrue(this.output.isActive());
    }
    
    @Test
    public void testChannelRemainsActiveIfInactiveInputIsAdded() {
        this.channel.addElement(this.activatedInput);
        assertTrue(this.channel.isActive());
        this.channel.addElement(this.deactivatedInput);
        assertTrue(this.channel.isActive());
    }
    
    @Test
    public void testChannelPassesReferenceToElementWhenItsAdded() {
        assertNull(this.activatedInput.getChannel());
        this.channel.addElement(this.activatedInput);
        assertSame(this.channel, this.activatedInput.getChannel());
    }
    
}
