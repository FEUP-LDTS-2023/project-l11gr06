package com.aor.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.aor.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class BlockTest {
    @Test
    void constructorAndGettersTest() {
        Block block = new Block(3, 3);

        Position position = block.getPosition();
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
    }


    @Test
    void testSetPosition() {
        Block block = new Block(3, 3);

        block.setPosition(new Position(5, 4));

        Position position = block.getPosition();
        assertEquals(5, position.getX());
        assertEquals(4, position.getY());
    }
}
