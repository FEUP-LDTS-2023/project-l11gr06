package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.HelpController;
import com.aor.supermario.model.Help;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.HelpViewer;
import com.aor.supermario.viewer.Viewer;

public class HelpState extends State<Help> {
    public HelpState(Help help) {
        super(help);
    }

    @Override
    protected Viewer<Help> getViewer() {
        return new HelpViewer(getModel());
    }

    @Override
    protected Controller<Help> getController() {
        return new HelpController(getModel(), getViewer());
    }
}


