package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class HelpController extends Controller<Help> {
    public HelpController(Help help, Viewer v) {
        super(help,v);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
        }
    }
}