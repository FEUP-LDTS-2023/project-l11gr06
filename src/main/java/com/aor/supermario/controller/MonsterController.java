package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Monster;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class MonsterController extends Controller<Map> {
    public MonsterController(Map map, Viewer v) {
        super(map, v);
    }
    private void moveMonster(Monster m,Position position) {
        m.setPosition(position);
    }
    public void moveDown(Monster m) {
        moveMonster(m,m.getPosition().getDown());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {}
}

