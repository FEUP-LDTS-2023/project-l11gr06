package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class GroundTest {
    @Test
    void constructorAndGettersTest() {
        Ground ground = new Ground(2, 5);

        Position position = ground.getPosition();
        assertEquals(2, position.getX());
        assertEquals(5, position.getY());
    }
    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        Ground g = new Ground(p);

        Position position = g.getPosition();
        assertEquals(p, position);

    }


    @Test
    void testSetPosition() {
        Ground ground = new Ground(2, 5);

        ground.setPosition(new Position(6, 4));

        Position position = ground.getPosition();
        assertEquals(6, position.getX());
        assertEquals(4, position.getY());
    }
}