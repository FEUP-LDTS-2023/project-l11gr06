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
        map.setBlocks(new ArrayList<>());
    }

    @Test
    void breakBlock_PlayerAdjacentToBlock_BlockBroken() {
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
        Map map = new Map(10, 5);

        List<Ground> grounds = new ArrayList<>();
        grounds.add(new Ground(new Position(1, 1)));
        grounds.add(new Ground(new Position(2, 1)));
        map.setGrounds(grounds);

        assertEquals(grounds, map.getGrounds());
    }
    @Test
    public void testGetBlocks() {
        Map map = new Map(10, 5);

        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Position(1, 1)));
        blocks.add(new Block(new Position(2, 1)));
        map.setBlocks(blocks);

        assertEquals(blocks, map.getBlocks());
    }
    @Test
    public void testGetPipes() {
        Map map = new Map(10, 5);

        List<Pipe> pipes = new ArrayList<>();
        pipes.add(new Pipe(new Position(1, 1)));
        pipes.add(new Pipe(new Position(2, 1)));
        map.setPipes(pipes);

        assertEquals(pipes, map.getPipes());
    }
    @Test
    public void testGetStairs() {
        Map map = new Map(10, 5);

        List<Stair> stairs = new ArrayList<>();
        stairs.add(new Stair(new Position(1, 1)));
        stairs.add(new Stair(new Position(2, 1)));
        map.setStairs(stairs);

        assertEquals(stairs, map.getStairs());
    }

}
