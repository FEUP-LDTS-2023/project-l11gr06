package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
//import com.aor.supermario.model.game.arena.LoaderArenaBuilder;
import com.ldts.supermario.model.About;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.Viewer;

import java.io.IOException;

public class AboutController extends Controller<About> {
    public AboutController(About about, Viewer v) {
        super(about, v);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP, RIGHT, DOWN, LEFT,JUMPR,JUMPL,NONE,QUIT: break;
            case SELECT:
                if (getModel().isSelectedMenu()) {
                    game.setState(new MenuState(new Menu()));
                }
        }
    }
}