package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class PipeTest {
    @Test
    void constructorAndGettersTest() {
        Pipe pipe = new Pipe(4, 1);

        Position position = pipe.getPosition();
        assertEquals(4, position.getX());
        assertEquals(1, position.getY());
    }
    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        Pipe pipe = new Pipe(p);

        Position position = pipe.getPosition();
        assertEquals(p, position);

    }


    @Test
    void testSetPosition() {
        Pipe pipe = new Pipe(4, 1);

        pipe.setPosition(new Position(2, 3));

        Position position = pipe.getPosition();
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }
}
