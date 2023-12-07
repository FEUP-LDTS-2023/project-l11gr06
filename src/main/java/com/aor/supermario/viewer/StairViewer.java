package com.aor.supermario.viewer;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.Stair;
import com.aor.supermario.gui.GUI;

public class StairViewer implements ElementViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(Element.getPosition());
    }
}