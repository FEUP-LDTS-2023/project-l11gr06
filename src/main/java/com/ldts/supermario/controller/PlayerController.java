package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.*;
import com.ldts.supermario.model.elements.GoalPole;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.states.GameOverState;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.VictoryState;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.elements.TurtleShell;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ldts.supermario.Main.lives;

public class PlayerController extends Controller<Map> {

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
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (getModel().collision_y(getModel().getPlayer())) {
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
                for (Monster monster : getModel().getMonsters()) {
                    if (getModel().monsterCollision(monster)) {
                        if (monster instanceof TurtleShell && ((TurtleShell) monster).getState() == 1)
                            ((TurtleShell) monster).setState(2);
                        else if(lives>1)
                        {
                            lives--;
                            game.setState(new GameState(new Map1Builder(250,20).createMap()));
                            return;
                        }
                        else
                        {
                            lives=3;
                            game.setState(new GameOverState(new GameOver()));
                            return;
                        }
                    }
                }
                for (GoalPole pole : getModel().getGoalPole())
                    if (getModel().getPlayer().getPosition().getX() == pole.getPosition().getX())
                        game.setState(new VictoryState(new Victory()));
                if (!getModel().collision_x_front(getModel().getPlayer())) {
                    if (getModel().getPlayer().getPosition().getX() < Game.width_game / 2)
                        moveRight();
                    else getModel().moveMap();
                }
            }
            if (action == GUI.ACTION.LEFT) {
                for (Monster monster : getModel().getMonsters()) {
                    if (getModel().monsterCollision(monster)) {
                        if (monster instanceof TurtleShell && ((TurtleShell) monster).getState() == 1)
                            ((TurtleShell) monster).setState(2);
                        else if(lives>1)
                        {
                            lives--;
                            game.setState(new GameState(new Map1Builder(250,20).createMap()));
                            return;
                        }
                        else
                        {
                            lives=3;
                            game.setState(new GameOverState(new GameOver()));
                            return;
                        }
                    }
                }
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
        }
        if (action == GUI.ACTION.NONE) {
            for(Monster monster: getModel().getMonsters())
            {
                if (getModel().monsterCollision(monster))
                {
                    if (monster instanceof TurtleShell && ((TurtleShell) monster).getState() == 1) ((TurtleShell) monster).setState(2);
                    else if(lives>1)
                    {
                        lives--;
                        game.setState(new GameState(new Map1Builder(250,20).createMap()));
                        return;
                    }
                    else
                    {
                        lives=3;
                        game.setState(new GameOverState(new GameOver()));
                        return;
                    }
                }
            }
            while (getModel().getPlayer().getPosition().getY() != getModel().getHeight() - 1) {
                getModel().getMonsters().removeIf(monster -> monster.getPosition().getX()==getModel().getPlayer().getPosition().getX() && monster.getPosition().getY()==getModel().getPlayer().getPosition().getY()+1);
                if (getModel().collision_y(getModel().getPlayer())) break;
                moveDown();
                getViewer().draw(game.getGui());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (getModel().collect_coins()){
                getViewer().draw(game.getGui());
                getModel().getPlayer().addPoint(100);
                getViewer().draw(game.getGui());
            }
            if (getModel().collect_mushroom()) {
                getViewer().draw(game.getGui());
                getModel().getPlayer().addPoint(1000);
                getViewer().draw(game.getGui());
            }
            if (getModel().getPlayer().getPosition().getY() == getModel().getHeight() - 1) {
                if(lives>1)
                {
                    game.setState(new GameState(new Map1Builder(250,20).createMap()));
                    lives--;
                }
                else
                {
                    game.setState(new GameOverState(new GameOver()));
                    lives=3;
                }

            }
        }
    }
}


