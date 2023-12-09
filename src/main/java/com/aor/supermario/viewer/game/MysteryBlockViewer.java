package com.aor.supermario.viewer.game;

import com.aor.supermario.model.elements.MysteryBlock;
import com.aor.supermario.gui.GUI;

public class MysteryBlockViewer implements ElementViewer<MysteryBlock> {
    @Override
    public void draw(MysteryBlock mysteryBlock, GUI gui) {
        gui.drawMysteryBlock(mysteryBlock.getPosition());
    }
}