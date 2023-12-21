package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.HelpController;
import com.ldts.supermario.model.Help;
import com.ldts.supermario.viewer.HelpViewer;
import com.ldts.supermario.viewer.Viewer;

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


