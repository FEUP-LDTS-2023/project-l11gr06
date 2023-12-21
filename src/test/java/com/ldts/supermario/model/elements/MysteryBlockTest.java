package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class MysteryBlockTest {
    @Test
    void constructorAndGettersTest() {
        MysteryBlock mysteryBlock = new MysteryBlock(5, 5);

        Position position = mysteryBlock.getPosition();
        assertEquals(5, position.getX());
        assertEquals(5, position.getY());
    }
    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        MysteryBlock m = new MysteryBlock(p);

        Position position = m.getPosition();
        assertEquals(p, position);

    }


    @Test
    void testSetPosition() {
        MysteryBlock mysteryBlock = new MysteryBlock(5, 5);

        mysteryBlock.setPosition(new Position(3, 4));

        Position position = mysteryBlock.getPosition();
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }
}
