package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.GameOverController;
import com.ldts.supermario.model.GameOver;
import com.ldts.supermario.viewer.GameOverViewer;
import com.ldts.supermario.viewer.Viewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver gameover) {
        super(gameover);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel(), getViewer());
    }
}


