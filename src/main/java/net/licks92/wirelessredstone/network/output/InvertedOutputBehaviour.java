package net.licks92.wirelessredstone.network.output;


public class InvertedOutputBehaviour implements OutputBehaviour {
    
    private OutputBehaviour output;
    
    public InvertedOutputBehaviour(OutputBehaviour output) {
        this.output = output;
    }

    @Override
    public void activate() {
        this.output.deactivate();
    }

    @Override
    public void deactivate() {
        this.output.activate();
    }

}
