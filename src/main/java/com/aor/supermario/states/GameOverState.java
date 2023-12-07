package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.GameOverController;
import com.aor.supermario.model.GameOver;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.GameOverViewer;
import com.aor.supermario.viewer.Viewer;

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
        return new GameOverController(getModel());
    }
}


