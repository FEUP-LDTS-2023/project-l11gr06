package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.Viewer;

public class GameOverState extends State<Map> {
    public GameOverState(Map map) {
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new ArenaController(getModel());
    }
}

}
