package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.util.Position;

/**
 * A generic input element
 */
public abstract class NetworkInput extends NetworkElement {

    public NetworkInput(Position pos) {
        super(pos);
    }

    /**
     * check if this input element delivers a signal
     * @return true if a signal should be broadcast to the channel
     */
    public boolean hasInputSignal() {
        return false; // TODO Implementation
    }
}
