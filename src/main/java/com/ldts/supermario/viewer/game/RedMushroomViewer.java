package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.RedMushroom;
import com.ldts.supermario.gui.GUI;

public class RedMushroomViewer implements ElementViewer<RedMushroom> {
    @Override
    public void draw(RedMushroom redMushroom, GUI gui) {
        gui.drawRedMushroom(redMushroom.getPosition());
    }
}