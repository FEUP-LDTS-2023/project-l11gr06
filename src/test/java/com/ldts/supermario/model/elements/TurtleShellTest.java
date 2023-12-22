package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleShellTest {

    @Test
    void testTurtleShellInitialization() {
        TurtleShell turtleShell = new TurtleShell(1, 2);

        assertEquals(1, turtleShell.getPosition().getX());
        assertEquals(2, turtleShell.getPosition().getY());
        assertEquals(1, turtleShell.getState());
        assertFalse(turtleShell.getMove());
        assertEquals(0, turtleShell.getMoveDirection());
    }

    @Test
    void testTurtleShellStateChange() {
        TurtleShell turtleShell = new TurtleShell(new Position(3, 4));

        turtleShell.setState(2);
        assertEquals(2, turtleShell.getState());

        turtleShell.setMove(true);
        assertTrue(turtleShell.getMove());

        turtleShell.setMoveDirection(1);
        assertEquals(1, turtleShell.getMoveDirection());

        turtleShell.setMoveDirection(0);
        assertEquals(0, turtleShell.getMoveDirection());
    }
}
