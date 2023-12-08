package com.aor.supermario.states;

import com.aor.supermario.controller.AboutController;
import com.aor.supermario.controller.Controller;
import com.aor.supermario.model.About;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.AboutViewer;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.viewer.game.GameViewer;

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
        return new AboutController(getModel());
    }
}

