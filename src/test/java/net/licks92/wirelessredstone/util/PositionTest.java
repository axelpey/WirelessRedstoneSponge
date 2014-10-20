package net.licks92.wirelessredstone.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

    /**
     * Simple Test to ensure the values are saved correctly.
     * 
     * Basically just to get the coverage.
     */
    @Test
    public void test() {
        Position pos = new Position(1, 2, 3, "world");
        assertEquals(1, pos.getPosX());
        assertEquals(2, pos.getPosY());
        assertEquals(3, pos.getPosZ());
        assertEquals("world", pos.getWorldName());
    }

}
