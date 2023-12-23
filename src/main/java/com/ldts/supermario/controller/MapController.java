package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.states.MenuState;
import com.ldts.supermario.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ldts.supermario.Main.lives;

public class MapController extends Controller<Map> {
    private final PlayerController playerController;

    public MapController(Map map, Viewer v) {
        super(map, v);

        this.playerController = new PlayerController(map,v );
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
        {
            game.setState(new MenuState(new Menu()));
            lives=3;
        }

        else {
            playerController.step(game, action, time);
        }
    }
}