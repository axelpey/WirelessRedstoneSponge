package net.licks92.wirelessredstone.network.output;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class InvertedOutputBehaviourTest {
    
    private Mockery context;
    
    @Before
    public void setup() {
        this.context = new Mockery();
    }

    @Test
    public void testActivateDeactivatesInnerOutputBehaviour() {
        final OutputBehaviour output = this.context.mock(OutputBehaviour.class);
        InvertedOutputBehaviour inverted = new InvertedOutputBehaviour(output);
        this.context.checking(new Expectations() {{
            oneOf(output).deactivate();
        }});
        inverted.activate();
        this.context.assertIsSatisfied();
    }
    
    @Test
    public void testDeactivateActivatesInnerOutputBehaviour() {
        final OutputBehaviour output = this.context.mock(OutputBehaviour.class);
        InvertedOutputBehaviour inverted = new InvertedOutputBehaviour(output);
        this.context.checking(new Expectations() {{
            oneOf(output).activate();
        }});
        inverted.deactivate();
        this.context.assertIsSatisfied();
    }

}
