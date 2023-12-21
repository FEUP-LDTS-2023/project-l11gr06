package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.Map1Builder;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.model.Victory;

import java.io.IOException;

public class VictoryController extends Controller<Victory> {
    public VictoryController(Victory victory, Viewer v) {
        super(victory, v);
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
                if (getModel().isSelectedExit()) System.exit(0);
        }
    }
}