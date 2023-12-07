package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
//import com.aor.supermario.model.game.arena.LoaderArenaBuilder;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Map1Builder;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.AboutState;
import com.aor.supermario.states.GameState;
import com.aor.supermario.states.HelpState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedHelp()) game.setState(new HelpState(new Help()));
                if (getModel().isSelectedAbout()) game.setState(new AboutState(new About()));
                if (getModel().isSelectedStart()) game.setState(new GameState(new Map1Builder().createMap()));
        }
    }
}