package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.elements.BrownMushroom;
import com.aor.supermario.model.elements.Coin;
import com.aor.supermario.model.elements.Element;
import com.aor.supermario.model.elements.RedMushroom;

public class BrownMushroomViewer implements ElementViewer<BrownMushroom> {

    @Override
    public void draw(BrownMushroom brownMushroom, GUI gui) {
        gui.drawRedMushroom(brownMushroom.getPosition());
    }
}

