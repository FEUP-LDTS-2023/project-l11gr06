package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Element;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class Gravity extends PlayerController implements Runnable{
    private Map map;
    private Viewer v;
    private Game game;
    private Element element;
    public Gravity(Map m, Viewer v, Game g, Element e)
    {
        super(m,v);
        map=m;
        game=g;
        element=e;
    }
    public void run() {
        while(element.getPosition().getY()!= getModel().getHeight())
        {
            if(element.getPosition().getY()== getModel().getHeight()-1 ) return;
            if(map.collision_y(element)) break;
            Position p = new Position(element.getPosition().getX(),element.getPosition().getY()+1);
            element.setPosition(p);
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

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        run();
    }
}
