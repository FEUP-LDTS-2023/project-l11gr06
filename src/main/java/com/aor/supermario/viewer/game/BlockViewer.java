package com.aor.supermario.viewer.game;

import com.aor.supermario.elements.Block;
import com.aor.supermario.elements.Element;
import com.aor.supermario.gui.GUI;

public class BlockViewer implements ElementViewer<Block> {
    @Override
    public void draw(Block block, GUI gui) {
        gui.drawBlock(Element.getPosition());
    }
}