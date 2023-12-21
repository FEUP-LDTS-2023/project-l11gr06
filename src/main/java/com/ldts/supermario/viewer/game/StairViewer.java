package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.Stair;
import com.ldts.supermario.gui.GUI;

public class StairViewer implements ElementViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(stair.getPosition());
    }
}