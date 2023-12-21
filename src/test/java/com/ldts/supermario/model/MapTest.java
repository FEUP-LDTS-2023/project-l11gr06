package com.ldts.supermario.model;

import com.ldts.supermario.model.elements.Block;
import com.ldts.supermario.model.elements.Ground;
import com.ldts.supermario.model.elements.Pipe;
import com.ldts.supermario.model.elements.Stair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
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
