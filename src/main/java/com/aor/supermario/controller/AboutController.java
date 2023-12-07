package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
//import com.aor.supermario.model.game.arena.LoaderArenaBuilder;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Map1Builder;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.AboutState;
import com.aor.supermario.states.MenuState;

import java.io.IOException;

public class AboutController extends Controller<About> {
    public AboutController(About about) {
        super(about);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
        }
    }
}