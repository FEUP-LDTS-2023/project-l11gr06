package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.MenuController;
import com.aor.supermario.model.Menu;
import com.aor.supermario.viewer.MenuViewer;
import com.aor.supermario.viewer.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;


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

