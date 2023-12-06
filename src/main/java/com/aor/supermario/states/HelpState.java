package com.aor.supermario.states;

import com.aor.supermario.Map;

public class HelpState extends State<Menu> {
    public HelpState(Menu model) {
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
