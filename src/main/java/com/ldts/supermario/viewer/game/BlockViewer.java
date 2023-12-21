package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.Block;
import com.ldts.supermario.gui.GUI;

public class BlockViewer implements ElementViewer<Block> {
    @Override
    public void draw(Block block, GUI gui) {
        gui.drawBlock(block.getPosition());
    }
}