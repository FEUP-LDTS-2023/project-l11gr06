package com.aor.supermario.controller;

import com.aor.supermario.Game;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Menu;
import com.aor.supermario.states.MenuState;

import java.io.IOException;

public class MapController extends GameController {
    private final PlayerController playerController;
    //private final MonsterController monsterController;

    public MapController(Map map) {
        super(map);

        this.playerController = new PlayerController(map);
        //this.monsterController = new MonsterController(map);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            playerController.step(game, action, time);
            //monsterController.step(game, action, time);
        }
    }
}