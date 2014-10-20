package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.network.io.OutputBehaviour;
import net.licks92.wirelessredstone.util.Position;

/**
 * A generic output element
 */
public class NetworkOutput extends NetworkElement {
    
    private OutputBehaviour output;
    private boolean isActive;

    public NetworkOutput(Position pos, OutputBehaviour output) {
        super(pos);
        this.output = output;
    }

    /**
     * Checks if the output element is active
     */
    public boolean isActive() {
        return this.isActive;
    }
    
    /**
     * Updates the Activation status of this element
     */
    public void setIsActive(boolean status) {
        if (status != this.isActive) {
            this.isActive = status;
            if (this.isActive) {
                this.output.activate();
            } else {
                this.output.deactivate();
            }
        }
    }
}
