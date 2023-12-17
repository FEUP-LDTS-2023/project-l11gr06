package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
//import com.aor.supermario.model.game.arena.LoaderArenaBuilder;
import com.aor.supermario.model.*;
import com.aor.supermario.states.AboutState;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.HelpState;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public int lives=3;
    public MenuController(Menu menu, Viewer v) {
        super(menu, v);
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
                if (getModel().isSelectedExit()) System.exit(0);
                if (getModel().isSelectedHelp()) game.setState(new HelpState(new Help()));
                if (getModel().isSelectedAbout()) game.setState(new AboutState(new About()));
                if (getModel().isSelectedStart()) {
                    while (lives > 0) {

                        game.setState(new GameState(new Map1Builder(250, 20).createMap()));
                        lives--;
                    }
                }
        }
    }
}