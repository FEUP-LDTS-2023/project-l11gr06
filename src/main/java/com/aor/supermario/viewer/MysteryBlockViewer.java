package com.aor.supermario.viewer;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.MysteryBlock;
import com.aor.supermario.gui.GUI;

public class MysteryBlockViewer implements ElementViewer<MysteryBlock> {
    @Override
    public void draw(MysteryBlock mysteryBlock, GUI gui) {
        gui.drawMysteryBlock(Element.getPosition());
    }
}