package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Menu;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Victory;
import com.aor.supermario.model.elements.*;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.states.VictoryState;
import com.aor.supermario.viewer.game.PlayerViewer;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.gui.LanternaGUI;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class PlayerController extends GameController {

    public PlayerController(Map map, Viewer v) {
        super(map, v);
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
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) {
            for (int i = 1; i <= 4; i++) {
                moveUp();
                getViewer().draw(game.getGui());
                if (getModel().break_block()) break;
                if (getModel().reveal_mysteryblock()) {
                    break;

                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (action == GUI.ACTION.RIGHT) {
            for (GoalPole pole : getModel().getGoalPole())
                if (getModel().getPlayer().getPosition().getX() == pole.getPosition().getX()) game.setState(new VictoryState(new Victory()));
            if (!getModel().collision_x_front(getModel().getPlayer())) {
                if (getModel().getPlayer().getPosition().getX() < Game.width_game / 2)
                    moveRight();
                else getModel().moveMap();
            }
        }
        if (action == GUI.ACTION.LEFT) {
            if (!getModel().collision_x_back(getModel().getPlayer()))
                if (getModel().getPlayer().getPosition().getX() != 0) moveLeft();
        }
        if (action == GUI.ACTION.JUMPR) {
            int x = 0;
            while (x < 4) {

                getViewer().draw(game.getGui());
                if (getModel().break_block()) {
                    getViewer().draw(game.getGui());
                    break;
                }
                if (getModel().reveal_mysteryblock()) {
                    getViewer().draw(game.getGui());
                    break;
                }
                moveUp();
                x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 4; i++) {
                if (getModel().collision_x_front(getModel().getPlayer())) break;

                for (GoalPole pole : getModel().getGoalPole())
                    if (getModel().getPlayer().getPosition().getX() == pole.getPosition().getX()) {
                        game.setState(new VictoryState(new Victory()));
                    }
                if (!getModel().collision_x_front(getModel().getPlayer())) {
                    if (getModel().getPlayer().getPosition().getX() < Game.width_game / 2)
                        moveRight();
                    else getModel().moveMap();
                }

                getViewer().draw(game.getGui());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if (action == GUI.ACTION.JUMPL) {
            int x = 0;
            while (x < 4) {
                getViewer().draw(game.getGui());
                if (getModel().break_block()) {
                    getViewer().draw(game.getGui());
                    break;
                }
                if (getModel().reveal_mysteryblock()) {
                    getViewer().draw(game.getGui());
                    break;
                }
                moveUp();
                x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 4; i++) {
                if (getModel().collision_x_front(getModel().getPlayer())) break;
                moveLeft();
                getViewer().draw(game.getGui());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (action == GUI.ACTION.NONE) {
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
        }
    }
}


