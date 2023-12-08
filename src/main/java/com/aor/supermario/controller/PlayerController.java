package com.aor.supermario.controller;


import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.elements.*;

public class PlayerController extends GameController {
    public PlayerController(Map map) {
        super(map);
    }

    /*    public Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
    public Position moveLeft() {
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position moveRight() {return new Position(getPosition().getX()+1, getPosition().getY());}*/

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
            for (GoalPole pole : getModel().getGoalPole())
                if (getModel().getPlayer().getPosition().getX() == pole.getPosition().getX()) System.exit(0);
            if (!getModel().collision_x_front()) {
                if (getModel().getPlayer().getPosition().getX() < Game.width_game / 2) movePlayer(getModel().getPlayer().moveRight());
                else {
                    for (Ground ground : getModel().getGrounds()) {
                        Position p = new Position(ground.getPosition().getX() - 1, ground.getPosition().getY());
                        ground.setPosition(p);
                    }
                    for (Block block : getModel().getBlocks()) {
                        Position p = new Position(block.getPosition().getX() - 1, block.getPosition().getY());
                        block.setPosition(p);
                    }
                    for (Stair stair : getModel().getStairs()) {
                        Position p = new Position(stair.getPosition().getX() - 1, stair.getPosition().getY());
                        stair.setPosition(p);
                    }
                    for (GoalPole pole : getModel().getGoalPole()) {
                        Position p = new Position(pole.getPosition().getX() - 1, pole.getPosition().getY());
                        pole.setPosition(p);
                    }
                    for (MysteryBlock mysteryblock : getModel().getMysteryBlocks()) {
                        Position p = new Position(mysteryblock.getPosition().getX() - 1, mysteryblock.getPosition().getY());
                        mysteryblock.setPosition(p);
                    }
                    for (Coin coin : getModel().getCoins()) {
                        Position p = new Position(coin.getPosition().getX() - 1, coin.getPosition().getY());
                        coin.setPosition(p);
                    }
                    for (RedMushroom rm : getModel().getRedMushrooms()) {
                        Position p = new Position(rm.getPosition().getX() - 1, rm.getPosition().getY());
                        rm.setPosition(p);
                    }
                    for (Pipe pipe : getModel().getPipes()) {
                        Position p = new Position(pipe.getPosition().getX() - 1, pipe.getPosition().getY());
                        pipe.setPosition(p);
                    }
                }
            }
        }
        if (action == GUI.ACTION.DOWN) {
            moveDown();
        }
        if (action == GUI.ACTION.LEFT) {
            if (!getModel().collision_x_back())
                if (getModel().getPlayer().getPosition().getX() != 0) moveLeft();
            }
        }
}
