package net.licks92.wirelessredstone.network.io;

/**
 * Output inverting.
 * 
 * <p>Works by passing method calls on to an internal OutputBehaviour</p>
 */
public class InvertedOutputBehaviour implements OutputBehaviour {
    
    private OutputBehaviour output;
    
    public InvertedOutputBehaviour(OutputBehaviour output) {
        this.output = output;
    }

    /**
     * will deactivate the internal Outputbehaviour
     * 
     * {@inheritDoc}
     */
    @Override
    public void activate() {
        this.output.deactivate();
    }

    /**
     * {@inheritDoc}
     * 
     * <p>will activate the interal Outputbehaviour</p>
     */
    @Override
    public void deactivate() {
        this.output.activate();
    }

}
