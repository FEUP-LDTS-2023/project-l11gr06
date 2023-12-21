package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.MysteryBlock;
import com.ldts.supermario.gui.GUI;

public class MysteryBlockViewer implements ElementViewer<MysteryBlock> {
    @Override
    public void draw(MysteryBlock mysteryBlock, GUI gui) {
        gui.drawMysteryBlock(mysteryBlock,mysteryBlock.getPosition());
    }
}