package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.*;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.MenuState;

import java.io.IOException;

public class VictoryController extends Controller<Victory> {
    public VictoryController(Victory victory) {
        super(victory);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedPlayAgain()) game.setState(new GameState(new Map1Builder(250,20).createMap()));
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }
}