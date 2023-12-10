package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.elements.*;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class TurtleShellMoving extends MonsterController implements Runnable{
    private Map map;
    private Viewer v;
    private Game game;
    private Monster monster;
    public TurtleShellMoving(Map m, Viewer v, Game g, Monster monster)
    {
        super(m,v);
        map=m;
        game=g;
        this.monster=monster;
    }
    public void run() {
        while(((TurtleShell) monster).getState()==2)
        {
            map.moveMonster(monster);
            try {
                getViewer().draw(game.getGui());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
