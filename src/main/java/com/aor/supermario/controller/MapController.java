package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MapController extends Controller<Map> {
    private final PlayerController playerController;

    public MapController(Map map, Viewer v) {
        super(map, v);

        this.playerController = new PlayerController(map,v );
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT) //|| getModel().getPlayer().getlives() == 0 IMPORTANTE MUDAR
            game.setState(new MenuState(new Menu()));
        else {
            playerController.step(game, action, time);
        }
    }
}