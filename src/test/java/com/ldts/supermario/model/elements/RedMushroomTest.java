package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class RedMushroomTest {
    @Test
    void constructorAndGettersTest() {
        RedMushroom redMushroom = new RedMushroom(2, 3);

        Position position = redMushroom.getPosition();
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }


    @Test
    void testSetPosition() {
        RedMushroom redMushroom = new RedMushroom(2, 3);

        redMushroom.setPosition(new Position(7, 9));

        Position position = redMushroom.getPosition();
        assertEquals(7, position.getX());
        assertEquals(9, position.getY());
    }
}
