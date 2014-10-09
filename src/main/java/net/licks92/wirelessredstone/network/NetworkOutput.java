package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.util.Position;

/**
 * A generic output element
 */
public abstract class NetworkOutput extends NetworkElement {

    public NetworkOutput(Position pos) {
        super(pos);
    }

    /**
     * Checks if the output element is active
     */
    public boolean isActive() {
        return false; // TODO Implementation
    }
    
    /**
     * Updates the Activation status of this element
     */
    public void setIsActive(boolean status) {
        // TODO Implementation
    }
}
