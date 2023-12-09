package com.aor.supermario.viewer.game;

import com.aor.supermario.model.elements.RedMushroom;
import com.aor.supermario.gui.GUI;

public class RedMushroomViewer implements ElementViewer<RedMushroom> {
    @Override
    public void draw(RedMushroom redMushroom, GUI gui) {
        gui.drawRedMushroom(redMushroom.getPosition());
    }
}