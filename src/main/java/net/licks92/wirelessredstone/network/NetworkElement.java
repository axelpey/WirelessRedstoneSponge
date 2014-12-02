package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.util.Position;


/**
 * Base Class for every point in a Network
 */
public class NetworkElement {
    
    private Position position;
    private WirelessChannel channel;

    public NetworkElement(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("NetworkElement cannot be created with 'null' as position");
        }
        this.position = pos;
    }
    
    /**
     * Get the position where this Element is located.
     * @return coordinates of the element
     */
    public Position getPosition() {
        return this.position;
    }
    
    /**
     * Set the channel this Element is associated to
     * @param channel
     */
    public void setChannel(WirelessChannel channel) {
        this.channel = channel;
    }
    
    /**
     * Get the associated channel
     * @return null if this element has not been added to a channel yet
     */
    public WirelessChannel getChannel() {
        return this.channel;
    }
    

}
