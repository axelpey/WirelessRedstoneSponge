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
     * Updates the Activation status of this element.
     *
     * <p>If the state is switched on (changing from {@code false} to {@code true}), the
     * {@link OutputBehaviour#activate()} method of the underlying Outputbehaviour will be called </p>
     * 
     * <p>If the state is switched off (changing from {@code true} to {@code false}), the
     * {@link OutputBehaviour#deactivate()} method of the underlying OutputBehaviour will be called</p>
     * 
     * <p>No calls will be made if the NetworkOutputs activation status does not change.</p>
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
