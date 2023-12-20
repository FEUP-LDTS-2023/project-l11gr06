package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Block;
import com.aor.supermario.viewer.game.BlockViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class BlockViewerTest {

    @Test
    void drawBlock() {
        GUI gui = Mockito.mock(GUI.class);
        Block block = new Block(new Position(5, 10));
        BlockViewer blockViewer = new BlockViewer();
        blockViewer.draw(block, gui);

        verify(gui).drawBlock(new Position(5, 10));
    }
}
