package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.elements.Ground;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui) {
        gui.drawGround(ground.getPosition());
    }
}