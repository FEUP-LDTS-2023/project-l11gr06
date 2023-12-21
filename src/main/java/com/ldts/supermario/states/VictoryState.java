package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.VictoryController;
import com.ldts.supermario.model.Victory;
import com.ldts.supermario.viewer.VictoryViewer;
import com.ldts.supermario.viewer.Viewer;

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
        return new VictoryController(getModel(), getViewer());
    }
}


