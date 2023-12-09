package com.aor.supermario.viewer.game;

import com.aor.supermario.model.elements.Stair;
import com.aor.supermario.gui.GUI;

public class StairViewer implements ElementViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(stair.getPosition());
    }
}