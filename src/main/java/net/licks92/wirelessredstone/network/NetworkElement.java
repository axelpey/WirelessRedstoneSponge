package net.licks92.wirelessredstone.network;

import net.licks92.wirelessredstone.util.Position;


/**
 * Interface containing essential data for every Point in the Network.
 */
public abstract class NetworkElement {
    
    private Position position;

    public NetworkElement(Position pos) {
        this.position = pos;
    }
    
    public Position getPosition() {
        return this.position;
    }
    

}
