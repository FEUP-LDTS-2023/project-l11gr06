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

    private Element element;
    public TurtleShellMoving(Map m, Viewer v, Game g, Element e)
    {
        super(m,v);
        map=m;
        game=g;
        element=e;
    }
    public void run() {
        while(true)
        {
            for(Monster m: getModel().monstersToMove()) {
                Thread t1 = new Thread(new Gravity(getModel(), getViewer(),game,m));
                t1.start();
                if(getModel().collision_y(m)) {
                    if(m instanceof BrownMushroom || (m instanceof TurtleShell && ((TurtleShell) m).getState()==0) ) {
                        getModel().moveMonster(m);
                    }
                    else if (m instanceof TurtleShell && ((TurtleShell) m).getState()==2)
                    {
                        Thread t2 = new Thread(new TurtleShellMoving(getModel(),v,game,m));
                        t2.start();
                    }
                    try {
                        getViewer().draw(game.getGui());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (getModel().monsterCollision(m))
                {
                    if(m instanceof TurtleShell && ((TurtleShell) m).getState()==1) ((TurtleShell) m).setState(2);
                    try {
                        game.getGui().close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                }
                if(getModel().monsterDies(m)) break;
                try {
                    getViewer().draw(game.getGui());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        run();
    }
}
