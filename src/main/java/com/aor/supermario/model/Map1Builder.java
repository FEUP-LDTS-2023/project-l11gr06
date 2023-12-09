package com.aor.supermario.model;

import com.aor.supermario.model.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Map1Builder extends MapBuilder{

    private final int width;
    private final int height;

    public Map1Builder(int width, int height) {
        this.width = width;
        this.height = height;
    }
    protected Player createPlayer() {
        Player player=new Player(1, getHeight()-4);
        return player;
    }
    @Override
    protected List<GoalPole> createGoalPole()
    {
        List<GoalPole> poles = new ArrayList<>();
        for(int i = 0; i < 9;i++) poles.add(new GoalPole(202, getHeight()-5-i));
        return poles;
    }
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    protected List<Ground> createGrounds() {
        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 71; c++) {
            grounds.add(new Ground(c, getHeight()- 1));
            grounds.add(new Ground(c, getHeight() - 2));
            grounds.add(new Ground(c, getHeight() - 3));
        }
        for(int c = 74; c <89;c++) {
            grounds.add(new Ground(c, getHeight() - 1));
            grounds.add(new Ground(c, getHeight() - 2));
            grounds.add(new Ground(c, getHeight() - 3));
        }
        for(int c = 92; c <156;c++) {
            grounds.add(new Ground(c, getHeight() - 1));
            grounds.add(new Ground(c, getHeight() - 2));
            grounds.add(new Ground(c, getHeight() - 3));
        }
        for(int c = 159; c <getWidth();c++) {
            grounds.add(new Ground(c, getHeight() - 1));
            grounds.add(new Ground(c, getHeight() - 2));
            grounds.add(new Ground(c, getHeight() - 3));
        }

        return grounds;
    }


    @Override
    protected List<Stair> createStairs() {
        List<Stair> stairs = new ArrayList<>();

        int i =0;
        for(int c = 137; c <141;c++) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, getHeight() - 4 -a));
            }
        }

        i =0;
        for(int c = 147; c > 143;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, getHeight() - 4 -a));
            }
        }
        i =0;
        for(int c = 151; c <156;c++) {
            if(c!=155)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, getHeight() - 4 -a));
            }
        }

        i =0;
        for(int c = 162; c >158;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, getHeight() - 4 -a));
            }
        }
        i =0;
        for(int c = 185; c <194;c++) {
            if(c!=193)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, getHeight() - 4 -a));
            }
        }
        stairs.add(new Stair(202,getHeight() - 4));
        return stairs;
    }
    @Override
    protected List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(22, getHeight() - 7));
        blocks.add(new Block(24, getHeight() - 7));
        blocks.add(new Block(26, getHeight() - 7));
        blocks.add(new Block(80, getHeight() - 7));
        blocks.add(new Block(82, getHeight() - 7));
        for(int i = 83; i<=90;i++) blocks.add(new Block(i, getHeight() - 12));
        for(int i = 94; i<=96;i++) blocks.add(new Block(i, getHeight() - 12));
        blocks.add(new Block(97, getHeight() - 7)); //TEM COIN
        blocks.add(new Block(103, getHeight() - 7));
        blocks.add(new Block(104, getHeight() - 7)); //TEM ESTRELA
        blocks.add(new Block(121, getHeight() - 7));
        for(int i = 124; i<=126;i++) blocks.add(new Block(i, getHeight() - 12));
        blocks.add(new Block(131, getHeight() - 12));
        blocks.add(new Block(132, getHeight() - 7));
        blocks.add(new Block(133, getHeight() - 7));
        blocks.add(new Block(134, getHeight() - 12));
        blocks.add(new Block(172, getHeight() - 7));
        blocks.add(new Block(173, getHeight() - 7));
        blocks.add(new Block(175, getHeight() - 7));
        return blocks;
    }

    @Override
    protected List<MysteryBlock> createMysteryBlocks()
    {
        List<MysteryBlock> mysteryBlocks = new ArrayList<>();
        mysteryBlocks.add(new MysteryBlock(18, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(23, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(25, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(24, getHeight() - 12));
        mysteryBlocks.add(new MysteryBlock(81, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(97, getHeight() - 12));
        mysteryBlocks.add(new MysteryBlock(109, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(112, getHeight() - 7));
        mysteryBlocks.add(new MysteryBlock(112, getHeight() - 12));
        mysteryBlocks.add(new MysteryBlock(132, getHeight() - 12));
        mysteryBlocks.add(new MysteryBlock(133, getHeight() - 12));
        mysteryBlocks.add(new MysteryBlock(174, getHeight() - 12));
        return mysteryBlocks;
    }
    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(18, getHeight() - 7));
        coins.add(new Coin(25, getHeight() - 7));
        coins.add(new Coin(24, getHeight() - 12));
        coins.add(new Coin(97, getHeight() - 12));
        coins.add(new Coin(109, getHeight() - 7));
        coins.add(new Coin(112, getHeight() - 7));
        coins.add(new Coin(132, getHeight() - 12));
        coins.add(new Coin(133, getHeight() - 12));
        coins.add(new Coin(174, getHeight() - 12));
        return coins;
    }
    @Override
    protected List<RedMushroom> createRedMushrooms() {
        List<RedMushroom> redMushrooms = new ArrayList<>();
        redMushrooms.add(new RedMushroom(23, getHeight() - 7));
        redMushrooms.add(new RedMushroom(81, getHeight() - 7));
        redMushrooms.add(new RedMushroom(112, getHeight() - 12));
        return redMushrooms;
    }

    @Override
    protected List<Pipe> createPipes(){
        List<Pipe> pipes = new ArrayList<>();
        pipes.add(new Pipe(30,getHeight()-4,'M'));
        pipes.add(new Pipe(30,getHeight()-5,'O'));
        pipes.add(new Pipe(31,getHeight()-4,'N'));
        pipes.add(new Pipe(31,getHeight()-5,'P'));
        pipes.add(new Pipe(40,getHeight()-4,'M'));
        pipes.add(new Pipe(40,getHeight()-5,'M'));
        pipes.add(new Pipe(40,getHeight()-6,'O'));
        pipes.add(new Pipe(41,getHeight()-4,'N'));
        pipes.add(new Pipe(41,getHeight()-5,'N'));
        pipes.add(new Pipe(41,getHeight()-6,'P'));
        pipes.add(new Pipe(48,getHeight()-4,'M'));
        pipes.add(new Pipe(48,getHeight()-5,'M'));
        pipes.add(new Pipe(48,getHeight()-6,'M'));
        pipes.add(new Pipe(48,getHeight()-7,'0'));
        pipes.add(new Pipe(49,getHeight()-4,'N'));
        pipes.add(new Pipe(49,getHeight()-5,'N'));
        pipes.add(new Pipe(49,getHeight()-6,'N'));
        pipes.add(new Pipe(49,getHeight()-7,'P'));
        pipes.add(new Pipe(59,getHeight()-4,'M'));
        pipes.add(new Pipe(59,getHeight()-5,'M'));
        pipes.add(new Pipe(59,getHeight()-6,'M'));
        pipes.add(new Pipe(59,getHeight()-7,'0'));
        pipes.add(new Pipe(60,getHeight()-4,'N'));
        pipes.add(new Pipe(60,getHeight()-5,'N'));
        pipes.add(new Pipe(60,getHeight()-6,'N'));
        pipes.add(new Pipe(60,getHeight()-7,'P'));
        pipes.add(new Pipe(167,getHeight()-4,'M'));
        pipes.add(new Pipe(167,getHeight()-5,'O'));
        pipes.add(new Pipe(168,getHeight()-4,'N'));
        pipes.add(new Pipe(168,getHeight()-5,'P'));
        pipes.add(new Pipe(183,getHeight()-4,'M'));
        pipes.add(new Pipe(183,getHeight()-5,'O'));
        pipes.add(new Pipe(184,getHeight()-4,'N'));
        pipes.add(new Pipe(184,getHeight()-5,'P'));
        return pipes;
    }
}
