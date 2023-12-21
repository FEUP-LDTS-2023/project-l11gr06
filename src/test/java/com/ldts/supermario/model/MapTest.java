package com.ldts.supermario.model;

import com.ldts.supermario.model.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MapTest {
    private Map map;
    private Player player;

    @BeforeEach
    void setUp() {
        map = new Map(10, 5);
        player = new Player(2,3);
        map.setPlayer(player);
    }

    @Test
    void breakBlock_PlayerAdjacentToBlock_BlockBroken() {
        map.setBlocks(new ArrayList<>());
        Block block = Mockito.mock(Block.class);
        when(block.getPosition()).thenReturn(player.getPosition());
        map.getBlocks().add(block);

        boolean blockBroken = map.break_block();

        assertTrue(blockBroken);
        assertEquals(50, player.getPoints());
        assertTrue(map.getBlocks().isEmpty());
    }

    @Test
    void breakBlock_PlayerNotAdjacentToBlock_NoBlockBroken() {
        map.setBlocks(new ArrayList<>());
        Block block = Mockito.mock(Block.class);
        when(block.getPosition()).thenReturn(new Position(1, 1));
        map.getBlocks().add(block);

        boolean blockBroken = map.break_block();

        assertFalse(blockBroken);
        assertEquals(0, player.getPoints());
        assertFalse(map.getBlocks().isEmpty());
    }

    @Test
    void constructorTest(){
        int expWidth = 5;
        int expHeight = 6;
        Map map = new Map(expWidth, expHeight);
        assertEquals(expWidth, map.getWidth());
        assertEquals(expHeight, map.getHeight());
    }
    @Test
    public void testGetGrounds() {
        List<Ground> grounds = new ArrayList<>();
        grounds.add(new Ground(new Position(1, 1)));
        grounds.add(new Ground(new Position(2, 1)));
        map.setGrounds(grounds);

        assertEquals(grounds, map.getGrounds());
    }
    @Test
    public void testGetBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Position(1, 1)));
        blocks.add(new Block(new Position(2, 1)));
        map.setBlocks(blocks);

        assertEquals(blocks, map.getBlocks());
    }
    @Test
    public void testGetPipes() {
        List<Pipe> pipes = new ArrayList<>();
        pipes.add(new Pipe(new Position(1, 1)));
        pipes.add(new Pipe(new Position(2, 1)));
        map.setPipes(pipes);

        assertEquals(pipes, map.getPipes());
    }
    @Test
    public void testGetStairs() {
        List<Stair> stairs = new ArrayList<>();
        stairs.add(new Stair(new Position(1, 1)));
        stairs.add(new Stair(new Position(2, 1)));
        map.setStairs(stairs);

        assertEquals(stairs, map.getStairs());
    }
    @Test
    void testRevealMysteryBlockwithcoin() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(map.getPlayer().getPosition()));
        map.setMysteryBlocks(mbs);

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(map.getPlayer().getPosition()));
        map.setCoins(coins);

        List<RedMushroom> rms = new ArrayList<>();
        rms.add(new RedMushroom(new Position(0,0)));
        map.setRedMushrooms(rms);

        boolean revealed = map.reveal_mysteryblock();
        assertTrue(revealed);
        for (MysteryBlock mysteryBlock : mbs) {
            assertEquals(1, mysteryBlock.getMysteryState());
            for (Coin coin : map.getCoins()) {
                assertNotEquals(mysteryBlock.getPosition(), coin.getPosition());
                assertEquals(mysteryBlock.getPosition().getY() - 1, coin.getPosition().getY());
            }
        }
    }

    @Test
    void testRevealMysteryBlockwithmushroom() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(map.getPlayer().getPosition()));
        map.setMysteryBlocks(mbs);

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(new Position(0,0)));
        map.setCoins(coins);

        List<RedMushroom> rms = new ArrayList<>();
        rms.add(new RedMushroom(map.getPlayer().getPosition()));
        map.setRedMushrooms(rms);

        boolean revealed = map.reveal_mysteryblock();
        assertTrue(revealed);
        for (MysteryBlock mysteryBlock : mbs) {
            assertEquals(1, mysteryBlock.getMysteryState());
            for (RedMushroom mushroom : map.getRedMushrooms()) {
                assertNotEquals(mysteryBlock.getPosition(), mushroom.getPosition());
                assertEquals(mysteryBlock.getPosition().getY() - 1, mushroom.getPosition().getY());
            }
        }
    }

    @Test
    void testCollectCoinsFailed() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(map.getPlayer().getPosition()));
        map.setMysteryBlocks(mbs);

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(map.getPlayer().getPosition()));
        map.setCoins(coins);

        boolean collected = map.collect_coins();
        assertFalse(collected);
        for (Coin c : coins) {
            assertTrue(map.getCoins().contains(c));
        }
    }

    @Test
    void testCollectCoinsPassed() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY()-1)));
        map.setMysteryBlocks(mbs);

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY()-2)));
        map.setCoins(coins);

        List<Block> blocks = new ArrayList<>();
        map.setBlocks(blocks);
        List<Pipe> pipes = new ArrayList<>();
        map.setPipes(pipes);
        List<Stair> stairs = new ArrayList<>();
        map.setStairs(stairs);
        List<Ground> grounds = new ArrayList<>();
        map.setGrounds(grounds);

        boolean collected = map.collect_coins();
        assertTrue(collected);
        for (Coin c : coins) {
            assertFalse(map.getCoins().contains(c));
        }
    }

    @Test
    void testCollectMushroomsFailed() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(map.getPlayer().getPosition()));
        map.setMysteryBlocks(mbs);

        List<RedMushroom> rms = new ArrayList<>();
        rms.add(new RedMushroom(map.getPlayer().getPosition()));
        map.setRedMushrooms(rms);

        boolean collected = map.collect_mushroom();
        assertFalse(collected);
        for (RedMushroom r : rms) {
            assertTrue(map.getRedMushrooms().contains(r));
        }
    }
    @Test
    void testCollectMushroomsFailed2() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY()-1)));
        map.setMysteryBlocks(mbs);

        List<RedMushroom> rm = new ArrayList<>();
        rm.add(new RedMushroom(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY()-2)));
        map.setRedMushrooms(rm);


        List<Block> blocks = new ArrayList<>();
        map.setBlocks(blocks);
        List<Pipe> pipes = new ArrayList<>();
        map.setPipes(pipes);
        List<Stair> stairs = new ArrayList<>();
        map.setStairs(stairs);
        List<Ground> grounds = new ArrayList<>();
        map.setGrounds(grounds);

        boolean collected = map.collect_mushroom();
        assertFalse(collected);
        for (RedMushroom r: rm) assertTrue(map.getRedMushrooms().contains(r));
    }


    @Test
    void testCollectMushroomPassed() {
        List<MysteryBlock> mbs = new ArrayList<>();
        mbs.add(new MysteryBlock(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY()-1)));
        map.setMysteryBlocks(mbs);

        List<RedMushroom> rm = new ArrayList<>();
        rm.add(new RedMushroom(new Position(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY())));
        map.setRedMushrooms(rm);


        List<Block> blocks = new ArrayList<>();
        map.setBlocks(blocks);
        List<Pipe> pipes = new ArrayList<>();
        map.setPipes(pipes);
        List<Stair> stairs = new ArrayList<>();
        map.setStairs(stairs);
        List<Ground> grounds = new ArrayList<>();
        map.setGrounds(grounds);

        boolean collected = map.collect_mushroom();
        assertTrue(collected);
        for (RedMushroom r: rm) assertFalse(map.getRedMushrooms().contains(r));
    }
}


