package com.aor.supermario.viewer;

import com.aor.supermario.elements.Element;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.elements.Ground;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui) {
        gui.drawGround(Element.getPosition());
    }
}