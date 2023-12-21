package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class GoalPoleTest {
    @Test
    void constructorAndGettersTest() {
        GoalPole goalPole = new GoalPole(5, 6);

        Position position = goalPole.getPosition();
        assertEquals(5, position.getX());
        assertEquals(6, position.getY());
    }


    @Test
    void testSetPosition() {
        GoalPole goalPole = new GoalPole(5, 6);

        goalPole.setPosition(new Position(2, 1));

        Position position = goalPole.getPosition();
        assertEquals(2, position.getX());
        assertEquals(1, position.getY());
    }
}