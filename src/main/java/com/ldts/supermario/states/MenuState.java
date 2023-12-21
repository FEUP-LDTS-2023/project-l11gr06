package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.MenuController;
import com.ldts.supermario.model.Menu;
import com.ldts.supermario.viewer.MenuViewer;
import com.ldts.supermario.viewer.Viewer;


public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel(), getViewer());
    }
}

