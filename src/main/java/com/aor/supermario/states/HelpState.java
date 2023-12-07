package com.aor.supermario.states;

import com.aor.supermario.model.Map;

public class HelpState extends State<Help> {
    public HelpState(Help model) {
        super(model);
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

}
