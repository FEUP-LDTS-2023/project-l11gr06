package com.ldts.supermario.model.elements;

import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    @Test
    void testMonsterMovement() {
        BrownMushroom monster = new BrownMushroom(new Position(0, 0));
        assertFalse(monster.getMove());

        monster.setMove(true);
        assertTrue(monster.getMove());

        monster.setMoveDirection(1);
        assertEquals(1, monster.getMoveDirection());

        monster.setMoveDirection(0);
        assertEquals(0, monster.getMoveDirection());

    }
}
