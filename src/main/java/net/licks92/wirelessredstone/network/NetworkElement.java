package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.util.Position;


/**
 * Interface containing essential data for every Point in the Network.
 */
public class NetworkElement {
    
    private Position position;

    public NetworkElement(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("NetworkElement cannot be created with 'null' as position");
        }
        this.position = pos;
    }
    
    public Position getPosition() {
        return this.position;
    }
    

}
