package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.MysteryBlock;
import com.aor.supermario.gui.GUI;
import com.aor.supermario.viewer.game.ElementViewer;

public class MysteryBlockViewer implements ElementViewer<MysteryBlock> {
    @Override
    public void draw(MysteryBlock mysteryBlock, GUI gui) {
        gui.drawMysteryBlock(Element.getPosition());
    }
}