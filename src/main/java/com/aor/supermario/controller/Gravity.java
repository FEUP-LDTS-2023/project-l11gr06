package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Element;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.model.elements.Player;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class Gravity extends MonsterController implements Runnable{
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
            //if(element.getPosition().getY()== getModel().getHeight()-1 && element instanceof Player) return;
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

}
