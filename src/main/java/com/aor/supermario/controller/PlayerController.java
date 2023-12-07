package com.aor.supermario.controller;


import com.aor.supermario.Game;
import com.aor.supermario.elements.*;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.googlecode.lanterna.input.KeyStroke;

public class PlayerController extends GameController {
    public PlayerController(Map map) {
        super(map);
    }

    public void moveLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void moveRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    public void moveUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    public void moveDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    private void movePlayer(Position position) {
        getModel().getPlayer().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            moveUp();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (action == GUI.ACTION.RIGHT) {
            for(GoalPole pole: getModel().getGoalPole()) if(Map.getPlayer().getPosition().getX()==pole.getPosition().getX()) System.exit(0);
            if(!collision_x_front())
            {
                if(Map.getPlayer().getPosition().getX()< Game.width_game/2) movePlayer(player.moveRight());
                else
                {
                    for(Ground ground: grounds)
                    {
                        Position p = new Position(ground.getPosition().getX()-1,ground.getPosition().getY());
                        ground.setPosition(p);
                    }
                    for(Block block: blocks)
                    {
                        Position p = new Position(block.getPosition().getX()-1,block.getPosition().getY());
                        block.setPosition(p);
                    }
                    for(Stair stair: stairs)
                    {
                        Position p = new Position(stair.getPosition().getX()-1,stair.getPosition().getY());
                        stair.setPosition(p);
                    }
                    for(GoalPole pole: poles)
                    {
                        Position p = new Position(pole.getPosition().getX()-1,pole.getPosition().getY());
                        pole.setPosition(p);
                    }
                    for(MysteryBlock mysteryblock:mysteryBlocks)
                    {
                        Position p = new Position(mysteryblock.getPosition().getX()-1,mysteryblock.getPosition().getY());
                        mysteryblock.setPosition(p);
                    }
                    for(Coin coin:coins)
                    {
                        Position p = new Position(coin.getPosition().getX()-1,coin.getPosition().getY());
                        coin.setPosition(p);
                    }
                    for(RedMushroom rm:redMushrooms)
                    {
                        Position p = new Position(rm.getPosition().getX()-1,rm.getPosition().getY());
                        rm.setPosition(p);
                    }

                    for(Pipe pipe: pipes)
                    {
                        Position p = new Position(pipe.getPosition().getX()-1,pipe.getPosition().getY());
                        pipe.setPosition(p);
                    }
                }
        }
        if (action == GUI.ACTION.DOWN) {
            moveDown();
        }
        if (action == GUI.ACTION.LEFT) {
            if(!collision_x_back())if(player.getPosition().getX()!=0)movePlayer(player.moveLeft());
            moveLeft();
        }
    }



    public void processKey(KeyStroke key) {
        System.out.println(key);
        String keyT = key.getKeyType().toString();
        int b_block = 0;
        switch (keyT) {
            case "ArrowUp":
                movePlayer(player.moveUp());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "ArrowLeft":
                if(!collision_x_back())if(player.getPosition().getX()!=0)movePlayer(player.moveLeft());
                break;
            case "ArrowRight":
                for(GoalPole pole: poles) if(player.getPosition().getX()==pole.getPosition().getX()) System.exit(0);
                if(!collision_x_front())
                {
                    if(player.getPosition().getX()< Game.width_game/2) movePlayer(player.moveRight());
                    else
                    {
                        for(Ground ground: grounds)
                        {
                            Position p = new Position(ground.getPosition().getX()-1,ground.getPosition().getY());
                            ground.setPosition(p);
                        }
                        for(Block block: blocks)
                        {
                            Position p = new Position(block.getPosition().getX()-1,block.getPosition().getY());
                            block.setPosition(p);
                        }
                        for(Stair stair: stairs)
                        {
                            Position p = new Position(stair.getPosition().getX()-1,stair.getPosition().getY());
                            stair.setPosition(p);
                        }
                        for(GoalPole pole: poles)
                        {
                            Position p = new Position(pole.getPosition().getX()-1,pole.getPosition().getY());
                            pole.setPosition(p);
                        }
                        for(MysteryBlock mysteryblock:mysteryBlocks)
                        {
                            Position p = new Position(mysteryblock.getPosition().getX()-1,mysteryblock.getPosition().getY());
                            mysteryblock.setPosition(p);
                        }
                        for(Coin coin:coins)
                        {
                            Position p = new Position(coin.getPosition().getX()-1,coin.getPosition().getY());
                            coin.setPosition(p);
                        }
                        for(RedMushroom rm:redMushrooms)
                        {
                            Position p = new Position(rm.getPosition().getX()-1,rm.getPosition().getY());
                            rm.setPosition(p);
                        }

                        for(Pipe pipe: pipes)
                        {
                            Position p = new Position(pipe.getPosition().getX()-1,pipe.getPosition().getY());
                            pipe.setPosition(p);
                        }
                    }
                }
                break;
        }
    }
}
