package net.licks92.wirelessredstone.util;

/**
 * Simple class for server-independently storing the location of a block
 */
public class Position {
    
    private int posX;
    private int posY;
    private int posZ;
    private String worldName;

    public Position(int posX, int posY, int posZ, String worldName) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.worldName = worldName;
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public int getPosZ() {
        return posZ;
    }
    
    public String getWorldName() {
        return worldName;
    }
    
}
