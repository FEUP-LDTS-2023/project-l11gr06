package com.aor.supermario.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void testGetLeft() {
        Position position = new Position(3, 5);
        Position left = position.getLeft();
        assertEquals(2, left.getX());
        assertEquals(5, left.getY());
    }

    @Test
    void testGetRight() {
        Position position = new Position(3, 5);
        Position right = position.getRight();
        assertEquals(4, right.getX());
        assertEquals(5, right.getY());
    }

    @Test
    void testGetUp() {
        Position position = new Position(3, 5);
        Position up = position.getUp();
        assertEquals(3, up.getX());
        assertEquals(4, up.getY());
    }

    @Test
    void testGetDown() {
        Position position = new Position(3, 5);
        Position down = position.getDown();
        assertEquals(3, down.getX());
        assertEquals(6, down.getY());
    }

    @Test
    void testEquals() {
        Position position1 = new Position(3, 5);
        Position position2 = new Position(3, 5);
        assertEquals(position1, position2);
    }
}
