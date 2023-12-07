package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.VictoryController;
import com.aor.supermario.model.Map;
import com.aor.supermario.model.Victory;
import com.aor.supermario.viewer.VictoryViewer;
import com.aor.supermario.viewer.Viewer;

public class VictoryState extends State<Victory> {
    public VictoryState(Victory victory) {
        super(victory);
    }

    @Override
    protected Viewer<Victory> getViewer() {
        return new VictoryViewer(getModel());
    }

    @Override
    protected Controller<Victory> getController() {
        return new VictoryController(getModel());
    }
}


