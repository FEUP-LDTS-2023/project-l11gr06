package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.elements.BrownMushroom;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.elements.Turtle;
import com.ldts.supermario.model.elements.TurtleShell;

public class MonsterMoving extends MonsterController implements Runnable {
    private Map map;
    private Viewer v;
    private Game game;
    public MonsterMoving(Map m, Viewer v, Game g) {
        super(m, v);
        map = m;
        game = g;
        this.v=v;
    }
    public void run() {
       while (true)
        {
            for (Monster m : getModel().monstersToMove()) {
                Thread t1 = new Thread(new MonsterGravity(getModel(), v, game, m));
                t1.start();
                if (getModel().collision_y(m)) {
                    getModel().moveMonster(m);
                }
            }
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
