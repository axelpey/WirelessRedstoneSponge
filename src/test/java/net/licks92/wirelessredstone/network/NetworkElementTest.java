package net.licks92.wirelessredstone.network;

import static org.junit.Assert.*;
import net.licks92.wirelessredstone.util.Position;

import org.junit.Test;

public class NetworkElementTest {

    @Test
    public void testPositionIsSaved() {
        Position position = new Position(12, 12, 12, "world");
        NetworkElement element = new NetworkElement(position);
        assertSame(position, element.getPosition());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCannotPassNullToConstructor() {
        new NetworkElement(null);
    }
    
    @Test
    public void testSetGetChannel() {
        WirelessChannel channel = new WirelessChannel("testchannel");
        NetworkElement element = new NetworkElement(new Position(12,12,12, "world"));
        element.setChannel(channel);
        assertSame(channel, element.getChannel());
    }

}
