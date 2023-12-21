package com.ldts.supermario.model;

import com.ldts.supermario.model.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Map1BuilderTest {
    private Map1Builder map1Builder;


    @BeforeEach
    void setUp() {
        map1Builder = new Map1Builder(205, 20);
    }


    @Test
    void numberOfGoalPoleCreatedTest() {
        List<GoalPole> poles = map1Builder.createGoalPole();
        assertEquals(9, poles.size());
    }

    @Test
    void numberOfGroundsCreatedTest() {
        List<Ground> grounds = map1Builder.createGrounds();
        assertEquals((map1Builder.getWidth()*3)-27, grounds.size());
    }

    @Test
    void numberOfStairsCreatedTest() {
        List<Stair> stairs = map1Builder.createStairs();
        assertEquals(89, stairs.size());
    }

    @Test
    void numberOfBlocksCreatedTest() {
        List<Block> blocks = map1Builder.createBlocks();
        assertEquals(30, blocks.size());
    }

    @Test
    void numberOfMysteryBlocksCreatedTest() {
        List<MysteryBlock> mysteryBlocks = map1Builder.createMysteryBlocks();
        assertEquals(13, mysteryBlocks.size());
    }

    @Test
    void numberOfCoinsCreatedTest() {
        List<Coin> coins = map1Builder.createCoins();
        assertEquals(10, coins.size());
    }

    @Test
    void numberOfRedMushroomsCreatedTest() {
        List<RedMushroom> redMushrooms = map1Builder.createRedMushrooms();
        assertEquals(3, redMushrooms.size());
    }

    @Test
    void numberOfPipesCreatedTest() {
        List<Pipe> pipes = map1Builder.createPipes();
        assertEquals(34, pipes.size());
    }

    @Test
    void numberOfMonstersCreatedTest() {
        List<Monster> monsters = map1Builder.createMonsters();
        assertEquals(15, monsters.size());
    }
}
