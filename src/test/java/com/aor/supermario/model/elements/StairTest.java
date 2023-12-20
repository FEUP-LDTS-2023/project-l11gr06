package com.aor.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.aor.supermario.model.Position;
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
    void testSetPosition() {
        Stair stair = new Stair(3, 3);

        stair.setPosition(new Position(5, 4));

        Position position = stair.getPosition();
        assertEquals(5, position.getX());
        assertEquals(4, position.getY());
    }
}
