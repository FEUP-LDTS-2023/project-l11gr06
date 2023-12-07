package com.aor.supermario.model;

import com.aor.supermario.elements.*;
import com.aor.supermario.model.*;
import com.aor.supermario.gui.*;
import java.util.ArrayList;
import java.util.List;

public class Map1Builder extends MapBuilder{
    @Override
    protected List<GoalPole> createGoalPole()
    {
        List<GoalPole> poles = new ArrayList<>();
        for(int i = 0; i < 9;i++) poles.add(new GoalPole(202,height-5-i));
        return poles;
    }

    @Override
    protected List<Map> createRedMushroom() {
        return null;
    }

    @Override
    protected Player createPlayer() {
        return null;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return 0;
    }

    @Override
    protected List<Ground> createGrounds() {
        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 71; c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 74; c <89;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 92; c <156;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }
        for(int c = 159; c <width;c++) {
            grounds.add(new Ground(c, height - 1));
            grounds.add(new Ground(c, height - 2));
            grounds.add(new Ground(c, height - 3));
        }

        return grounds;
    }

    @Override
    protected List<Map> createStair() {
        return null;
    }

    @Override
    protected List<Stair> createStairs() {
        List<Stair> stairs = new ArrayList<>();

        int i =0;
        for(int c = 137; c <141;c++) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }

        i =0;
        for(int c = 147; c > 143;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        i =0;
        for(int c = 151; c <156;c++) {
            if(c!=155)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }

        i =0;
        for(int c = 162; c >158;c--) {
            i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        i =0;
        for(int c = 185; c <194;c++) {
            if(c!=193)i++;
            for(int a =0;a<i;a++)
            {
                stairs.add(new Stair(c, height - 4 -a));
            }
        }
        stairs.add(new Stair(202,height-4));
        return stairs;
    }
    @Override
    protected List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(22, height - 7));
        blocks.add(new Block(24, height - 7));
        blocks.add(new Block(26, height - 7));
        blocks.add(new Block(80, height - 7));
        blocks.add(new Block(82, height - 7));
        for(int i = 83; i<=90;i++) blocks.add(new Block(i, height - 12));
        for(int i = 94; i<=96;i++) blocks.add(new Block(i, height - 12));
        blocks.add(new Block(97, height - 7)); //TEM COIN
        blocks.add(new Block(103, height - 7));
        blocks.add(new Block(104, height - 7)); //TEM ESTRELA
        blocks.add(new Block(121, height - 7));
        for(int i = 124; i<=126;i++) blocks.add(new Block(i, height - 12));
        blocks.add(new Block(131, height - 12));
        blocks.add(new Block(132, height - 7));
        blocks.add(new Block(133, height - 7));
        blocks.add(new Block(134, height - 12));
        blocks.add(new Block(172, height - 7));
        blocks.add(new Block(173, height - 7));
        blocks.add(new Block(175, height - 7));
        return blocks;
    }

    protected List<MysteryBlock> createMysteryBlocks()
    {
        List<MysteryBlock> mysteryBlocks = new ArrayList<>();
        mysteryBlocks.add(new MysteryBlock(18, height - 7));
        mysteryBlocks.add(new MysteryBlock(23, height - 7));
        mysteryBlocks.add(new MysteryBlock(25, height - 7));
        mysteryBlocks.add(new MysteryBlock(24, height - 12));
        mysteryBlocks.add(new MysteryBlock(81, height - 7));
        mysteryBlocks.add(new MysteryBlock(97, height - 12));
        mysteryBlocks.add(new MysteryBlock(109, height - 7));
        mysteryBlocks.add(new MysteryBlock(112, height - 7));
        mysteryBlocks.add(new MysteryBlock(112, height - 12));
        mysteryBlocks.add(new MysteryBlock(132, height - 12));
        mysteryBlocks.add(new MysteryBlock(133, height - 12));
        mysteryBlocks.add(new MysteryBlock(174, height - 12));
        return mysteryBlocks;
    }

    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(18, height - 7));
        coins.add(new Coin(25, height - 7));
        coins.add(new Coin(24, height - 12));
        coins.add(new Coin(97, height - 12));
        coins.add(new Coin(109, height - 7));
        coins.add(new Coin(112, height - 7));
        coins.add(new Coin(132, height - 12));
        coins.add(new Coin(133, height - 12));
        coins.add(new Coin(174, height - 12));
        return coins;
    }

    protected List<RedMushroom> createRedMushrooms() {
        List<RedMushroom> redMushrooms = new ArrayList<>();
        redMushrooms.add(new RedMushroom(23, height - 7));
        redMushrooms.add(new RedMushroom(81, height - 7));
        redMushrooms.add(new RedMushroom(112, height - 12));
        return redMushrooms;
    }


    protected List<Pipe> createPipes(){
        List<Pipe> pipes = new ArrayList<>();
        pipes.add(new Pipe(30,height-4,'M'));
        pipes.add(new Pipe(30,height-5,'O'));
        pipes.add(new Pipe(31,height-4,'N'));
        pipes.add(new Pipe(31,height-5,'P'));
        pipes.add(new Pipe(40,height-4,'M'));
        pipes.add(new Pipe(40,height-5,'M'));
        pipes.add(new Pipe(40,height-6,'O'));
        pipes.add(new Pipe(41,height-4,'N'));
        pipes.add(new Pipe(41,height-5,'N'));
        pipes.add(new Pipe(41,height-6,'P'));
        pipes.add(new Pipe(48,height-4,'M'));
        pipes.add(new Pipe(48,height-5,'M'));
        pipes.add(new Pipe(48,height-6,'M'));
        pipes.add(new Pipe(48,height-7,'0'));
        pipes.add(new Pipe(49,height-4,'N'));
        pipes.add(new Pipe(49,height-5,'N'));
        pipes.add(new Pipe(49,height-6,'N'));
        pipes.add(new Pipe(49,height-7,'P'));
        pipes.add(new Pipe(59,height-4,'M'));
        pipes.add(new Pipe(59,height-5,'M'));
        pipes.add(new Pipe(59,height-6,'M'));
        pipes.add(new Pipe(59,height-7,'0'));
        pipes.add(new Pipe(60,height-4,'N'));
        pipes.add(new Pipe(60,height-5,'N'));
        pipes.add(new Pipe(60,height-6,'N'));
        pipes.add(new Pipe(60,height-7,'P'));
        pipes.add(new Pipe(167,height-4,'M'));
        pipes.add(new Pipe(167,height-5,'O'));
        pipes.add(new Pipe(168,height-4,'N'));
        pipes.add(new Pipe(168,height-5,'P'));
        pipes.add(new Pipe(183,height-4,'M'));
        pipes.add(new Pipe(183,height-5,'O'));
        pipes.add(new Pipe(184,height-4,'N'));
        pipes.add(new Pipe(184,height-5,'P'));
        return pipes;
    }
}
