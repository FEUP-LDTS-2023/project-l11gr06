package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;
import com.aor.supermario.viewer.Viewer;

import java.io.IOException;

public class MapController extends GameController {
    private final PlayerController playerController;
    //private final MonsterController monsterController;

    public MapController(Map map, Viewer v) {
        super(map, v);

        this.playerController = new PlayerController(map,v );
        //this.monsterController = new MonsterController(map);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) //|| getModel().getPlayer().getlives() == 0 IMPORTANTE MUDAR
            game.setState(new MenuState(new Menu()));
        else {
            playerController.step(game, action, time);
            //monsterController.step(game, action, time);
        }
    }
}