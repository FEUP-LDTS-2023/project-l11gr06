package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class StairTest {
    @Test
    void constructorAndGettersTest() {
        Stair stair = new Stair(3, 3);

        Position position = stair.getPosition();
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        Stair s= new Stair(p);

        Position position = s.getPosition();
        assertEquals(p, position);

    }

    @Test
    void testSetPosition() {
        Stair stair = new Stair(3, 3);

        stair.setPosition(new Position(5, 4));

        Position position = stair.getPosition();
        assertEquals(5, position.getX());
        assertEquals(4, position.getY());
    }
}
