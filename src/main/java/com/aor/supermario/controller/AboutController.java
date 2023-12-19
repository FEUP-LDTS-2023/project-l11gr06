package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
//import com.aor.supermario.model.game.arena.LoaderArenaBuilder;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class AboutController extends Controller<About> {
    public AboutController(About about, Viewer v) {
        super(about, v);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP: break;
            case SELECT:
                if (getModel().isSelectedMenu()) {
                    game.setState(new MenuState(new Menu()));
                    System.out.println(game.getState().getClass());
                }
        }
    }
}