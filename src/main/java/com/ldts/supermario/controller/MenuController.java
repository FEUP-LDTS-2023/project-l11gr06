package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.states.AboutState;
import com.ldts.supermario.states.GameState;
import com.ldts.supermario.states.HelpState;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.model.About;
import com.ldts.supermario.model.Help;
import com.ldts.supermario.model.Map1Builder;
import com.ldts.supermario.model.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController extends Controller<Menu> {
    public int lives=3;
    public MenuController(Menu menu, Viewer v) {
        super(menu, v);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case RIGHT, LEFT, JUMPR, JUMPL, NONE, QUIT:break;
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