package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.RedMushroom;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.viewer.game.ElementViewer;

public class RedMushroomViewer implements ElementViewer<RedMushroom> {
    @Override
    public void draw(RedMushroom redMushroom, GUI gui) {
        gui.drawRedMushroom(Element.getPosition());
    }
}