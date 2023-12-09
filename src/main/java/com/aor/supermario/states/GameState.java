package com.aor.supermario.states;
import com.aor.supermario.Game;
import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.MapController;
import com.aor.supermario.controller.MonsterMoving;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;

public class GameState extends State<Map> {
    private Game game;
    public GameState(Map map) {
        super(map);
    }

    @Override
    public Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel(), getViewer());
    }
}