package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.elements.Element;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.viewer.Viewer;

import java.io.IOException;

public class MonsterGravity extends MonsterController implements Runnable{
    private Map map;
    private Viewer v;
    private Game game;

    private Element element;
    public MonsterGravity(Map m, Viewer v, Game g, Element e)
    {
        super(m,v);
        map=m;
        game=g;
        element=e;
        this.v=v;
    }
    @Override
    public void run() {
        while(element.getPosition().getY()!= getModel().getHeight())
        {
            if(element.getPosition().getY()== getModel().getHeight() ) return;
            if(map.collision_y(element)) break;
            moveDown((Monster) element);
            try {
                v.draw(game.getGui());

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
