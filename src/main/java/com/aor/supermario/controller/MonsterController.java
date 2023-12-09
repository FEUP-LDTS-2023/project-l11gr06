package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.model.elements.Turtle;
import com.aor.supermario.model.elements.TurtleShell;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class MonsterController extends GameController {
    public MonsterController(Map map, Viewer v) {
        super(map, v);
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
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        /*
            while (getModel().getPlayer().getPosition().getY() != getModel().getHeight()-1) {
                if (getModel().collision_y(getModel().getPlayer())) break;
                moveDown();
                getViewer().draw(game.getGui());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (getModel().getPlayer().getPosition().getY() == getModel().getHeight() - 1) {
                game.getGui().close();
            }

         */


    }
}

