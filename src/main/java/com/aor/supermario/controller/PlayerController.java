package com.aor.supermario.controller;


import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.Map;

public class PlayerController extends GameController {
    public PlayerController(Map map) {
        super(map);
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
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveUp();
        if (action == GUI.ACTION.RIGHT) moveRight();
        if (action == GUI.ACTION.DOWN) moveDown();
        if (action == GUI.ACTION.LEFT) moveLeft();
    }
}
