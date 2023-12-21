package com.ldts.supermario.states;

import com.ldts.supermario.controller.AboutController;
import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.model.About;
import com.ldts.supermario.viewer.AboutViewer;
import com.ldts.supermario.viewer.Viewer;

public class AboutState extends State<About> {
    public AboutState(About about) {
        super(about);
    }

    @Override
    protected Viewer<About> getViewer() {
        return new AboutViewer(getModel());
    }

    @Override
    protected Controller<About> getController() {
        return new AboutController(getModel(), getViewer());
    }
}

