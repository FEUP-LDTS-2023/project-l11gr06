package com.aor.supermario.states;
import com.aor.supermario.Map;
public class GameState extends State<Map> {
    public GameState(Map map) {
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new ArenaController(getModel());
    }
}
