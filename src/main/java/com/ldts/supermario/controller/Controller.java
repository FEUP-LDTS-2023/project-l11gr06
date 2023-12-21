package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;
    private final Viewer viewer;
    public Controller(T model, Viewer viewer) {
            this.model = model;
            this.viewer=viewer;
        }
    public T getModel() { return model; }
    public Viewer getViewer() { return viewer; }
    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException;
}

