package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.network.io.InputSource;
import net.licks92.wirelessredstone.util.Position;

/**
 * A generic input element
 */
public abstract class NetworkInput extends NetworkElement {

    private InputSource source;

    public NetworkInput(Position pos, InputSource input) {
        super(pos);
        this.source = input;
    }

    /**
     * check if this input element delivers a signal
     * @return true if a signal should be broadcast to the channel
     */
    public boolean hasInputSignal() {
        return this.source.hasInputSignal();
    }
}
