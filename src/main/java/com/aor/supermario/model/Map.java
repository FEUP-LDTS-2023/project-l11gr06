package com.aor.supermario.model;

import com.aor.supermario.Game;
import com.aor.supermario.controller.PlayerController;
import com.aor.supermario.model.elements.*;

import java.util.List;

public class Map {
    private Player player;
    private final int width;
    private final int height;
    private List<Ground> grounds;
    private List<Block> blocks;
    private List<Stair> stairs;
    private List<GoalPole> poles;
    private List<MysteryBlock> mysteryBlocks;
    private List<Coin> coins;
    private List<RedMushroom> redMushrooms;
    private List<Pipe> pipes;

    //private List<Monster> monsters;

    public Map(int width,int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    //public List<Monster> getMonsters() {
    //    return monsters;
    //}

    //public void setMonsters(List<Monster> monsters) {
    //    this.monsters = monsters;
    //}

    public List<Ground> getGrounds() {
        return grounds;
    }
    public void setGrounds(List<Ground> grounds) {
        this.grounds = grounds;
    }
    public List<Block> getBlocks() {
        return blocks;
    }
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
    public List<Coin> getCoins() {
        return coins;
    }
    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
    public List<GoalPole> getGoalPole() {
        return poles;
    }
    public void setGoalPoles(List<GoalPole> poles) {
        this.poles = poles;
    }
    public List<MysteryBlock> getMysteryBlocks() {
        return mysteryBlocks;
    }
    public void setMysteryBlocks(List<MysteryBlock> mysteryBlocks) {
        this.mysteryBlocks = mysteryBlocks;
    }
    public List<Pipe> getPipes() {
        return pipes;
    }
    public void setPipes(List<Pipe> pipes) {
        this.pipes = pipes;
    }
    public List<RedMushroom> getRedMushrooms() {
        return redMushrooms;
    }
    public void setRedMushrooms(List<RedMushroom> redMushrooms) {
        this.redMushrooms = redMushrooms;
    }
    public List<Stair> getStairs() {
        return stairs;
    }
    public void setStairs(List<Stair> stairs) {
        this.stairs = stairs;
    }

    public boolean canPlayerMove(Position p)
    {
        for (Ground ground : grounds){
            if (ground.getPosition().equals(p)) return false;}
        return p.getX()<width-1 && p.getX()>0 && p.getY()<height-3 && p.getY()>0;

    }

/*
    public void movePlayer(Position position) {
        player.setPosition(position);}*/

    public boolean break_block()
    {
        for(Block block:blocks)
        {
            if(player.getPosition().equals(block.getPosition()))
            {
                blocks.remove(block);
                return true;
            }
        }
        return false;
    }

    public boolean reveal_mysteryblock()
    {
        for(MysteryBlock mysteryblock:getMysteryBlocks())
        {
            if(getPlayer().getPosition().equals(mysteryblock.getPosition()))
            {
                mysteryblock.setMysteryState(1);
                for (Coin coin:getCoins()) {
                    if (coin.getPosition().equals(mysteryblock.getPosition())) {
                        Position p =new Position(coin.getPosition().getX(), coin.getPosition().getY()-1);
                        coin.setPosition(p);
                    }
                }
                for (RedMushroom mushroom:getRedMushrooms()) {
                    if (mushroom.getPosition().equals(mysteryblock.getPosition())) {
                        Position p =new Position(mushroom.getPosition().getX(), mushroom.getPosition().getY()-1);
                        mushroom.setPosition(p);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean collect_coins() {
        for(Coin coin:coins) {
            for (MysteryBlock m:mysteryBlocks) {
                if (coin.getPosition().equals(m.getPosition())) return false;
            }
            if (player.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean collect_mushroom() {
        for(RedMushroom rm:redMushrooms) {
            for (MysteryBlock m:mysteryBlocks) {
                if (rm.getPosition().equals(m.getPosition())) return false;
            }
            if (player.getPosition().equals(rm.getPosition())) {
                //SUPERMARIO STATE
                redMushrooms.remove(rm);
                return true;
            }
        }
        return false;
    }

    public boolean collision_y(Element element)
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX(),block.getPosition().getY()-1);
            if(element.getPosition().equals(p)&&element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX(),ground.getPosition().getY()-1);
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX(),stair.getPosition().getY()-1);
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX(),mysteryblock.getPosition().getY()-1);
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Pipe pipe:pipes)
        {
            Position p = new Position(pipe.getPosition().getX(),pipe.getPosition().getY()-1);
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        return false;
    }
    public boolean collision_x_front(Element element)
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX()-1,block.getPosition().getY());
            if(element.getPosition().equals(p)&&element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX()-1,ground.getPosition().getY());
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX()-1,stair.getPosition().getY());
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX()-1,mysteryblock.getPosition().getY());
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Pipe pipe:pipes)
        {
            Position p = new Position(pipe.getPosition().getX()-1,pipe.getPosition().getY());
            if(element.getPosition().equals(p))
            {
                return true;
            }
        }
        return false;
    }
    public boolean collision_x_back()
    {
        for(Block block:blocks)
        {
            Position p = new Position(block.getPosition().getX()+1,block.getPosition().getY());
            if(player.getPosition().equals(p)&&player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Ground ground:grounds)
        {
            Position p = new Position(ground.getPosition().getX()+1,ground.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Stair stair:stairs)
        {
            Position p = new Position(stair.getPosition().getX()+1,stair.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(MysteryBlock mysteryblock:mysteryBlocks)
        {
            Position p = new Position(mysteryblock.getPosition().getX()+1,mysteryblock.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }
        for(Pipe pipe:pipes)
        {
            Position p = new Position(pipe.getPosition().getX()+1,pipe.getPosition().getY());
            if(player.getPosition().equals(p))
            {
                return true;
            }
        }

        return false;
    }


}
