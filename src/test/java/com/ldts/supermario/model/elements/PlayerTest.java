package com.ldts.supermario.model.elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void testConstructorAndGetters() {

        Player player = new Player(3, 5);

        assertEquals(3, player.getPosition().getX());
        assertEquals(5, player.getPosition().getY());

        assertEquals(0, player.getPoints());
    }

    @Test
    void testAddPoint() {
        Player player = new Player(3, 5);

        player.addPoint(10);

        assertEquals(10, player.getPoints());
    }

}

