package com.aor.supermario.states;

import com.aor.supermario.model.Map;

public class VictoryState extends State<Map> {
    public VictoryState(Map map) {
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


