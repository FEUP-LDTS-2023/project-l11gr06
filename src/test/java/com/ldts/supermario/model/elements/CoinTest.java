package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class CoinTest {
    @Test
    void constructorAndGettersTest() {
        Coin coin = new Coin(8, 2);

        Position position = coin.getPosition();
        assertEquals(8, position.getX());
        assertEquals(2, position.getY());
    }


    @Test
    void testSetPosition() {
        Coin coin = new Coin(8, 2);

        coin.setPosition(new Position(7, 5));

        Position position = coin.getPosition();
        assertEquals(7, position.getX());
        assertEquals(5, position.getY());
    }
}