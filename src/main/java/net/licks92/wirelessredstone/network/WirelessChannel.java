package net.licks92.wirelessredstone.network;

import java.util.HashSet;
import java.util.Set;

public class WirelessChannel {
    
    private String name;
    private boolean isActive;
    
    private Set<NetworkInput> inputs = new HashSet<NetworkInput>();
    private Set<NetworkOutput> outputs = new HashSet<NetworkOutput>();

    /**
     * Get the channel's name.
     * @return name of the channel
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gives all Elements in this channel
     * @return Collection of all Elements in the channel.
     */
    public Set<NetworkElement> getAllElements() {
        Set<NetworkElement> elements = new HashSet<NetworkElement>();
        elements.addAll(this.inputs);
        elements.addAll(this.outputs);
        return elements;
    }
    
    /**
     * Gives all Input Elements in this channel
     * @return Collection of all Input Elements in the channel
     */
    public Set<NetworkInput> getInputs() {
        return this.inputs;
    }
    
    /**
     * Gives all Output Elements in this channel
     * @return Collection of all Output Elements in the channel
     */
    public Set<NetworkOutput> getOutputs() {
        return this.outputs;
    }
    
    /**
     * 
     * @return true if there currently is a signal broadcast by this channel
     */
    public boolean isActive() {
        return this.isActive;
    }
    
    /**
     * Register an Element to this channel. <br />
     * <br />
     * Output Elements will automatically be updated with the Channels current state
     * @param element new element to add
     * @throws IllegalArgumentException if an unsupported NetworkElement is provided
     */
    public void addElement(NetworkElement element) {
        if (element instanceof NetworkInput) {
            this.inputs.add((NetworkInput) element);
        } else if (element instanceof NetworkOutput) {
            this.outputs.add((NetworkOutput) element);
        } else {
            throw new IllegalArgumentException();
        }
        this.update();
    }
    
    /**
     * Update this channel <br />
     * <br />
     * This includes checking if there is an input signal and applying the signal to all outputs.
     */
    public void update() {
        this.isActive = this.hasInputSignal();
        for (NetworkOutput output : this.outputs) {
            if (output.isActive() == this.isActive) {
                output.setIsActive(this.isActive);
            }
        }
    }
    
    private boolean hasInputSignal() {
        for (NetworkInput input : this.inputs) {
            if (input.hasInputSignal()) {
                return true;
            }
        }
        return false;
    }
}

