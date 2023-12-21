package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.Monster;
import com.ldts.supermario.viewer.Viewer;

import java.io.IOException;

public class MonsterController extends Controller<Map> {
    public MonsterController(Map map, Viewer v) {
        super(map, v);
    }
    private void moveMonster(Monster m, Position position) {
        m.setPosition(position);
    }
    public void moveDown(Monster m) {
        moveMonster(m,m.getPosition().getDown());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {}
}

