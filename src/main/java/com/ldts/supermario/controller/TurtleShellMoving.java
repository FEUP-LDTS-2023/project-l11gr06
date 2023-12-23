package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.elements.TurtleShell;

import java.io.IOException;

public class TurtleShellMoving extends MonsterController implements Runnable{
    private Map map;
    private Viewer v;
    private Game game;
    public TurtleShellMoving(Map m, Viewer v, Game g) {
        super(m, v);
        map = m;
        game = g;
        this.v=v;
    }
    @Override
    public void run() {
        while (true)
        {
            for (Monster monster : getModel().shellsToMove()) {

                Thread t1 = new Thread(new MonsterGravity(getModel(), v, game, monster));
                t1.start();


                if(((TurtleShell) monster).getState()==2)
                {
                    getModel().moveMonster(monster);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
