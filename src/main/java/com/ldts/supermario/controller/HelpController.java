package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Help;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.Viewer;

import java.io.IOException;

public class HelpController extends Controller<Help> {
    public HelpController(Help help, Viewer v) {
        super(help,v);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP, RIGHT, DOWN, LEFT, JUMPR, JUMPL, NONE, QUIT: break;
            case SELECT:
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
        }
    }
}