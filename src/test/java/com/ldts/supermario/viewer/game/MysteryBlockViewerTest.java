package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.MysteryBlock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class MysteryBlockViewerTest {

    @Test
    void drawMysteryBlock() {
        GUI gui = Mockito.mock(GUI.class);
        MysteryBlock mb = new MysteryBlock(new Position(5, 10));
        MysteryBlockViewer mysteryblockViewer = new MysteryBlockViewer();
        mysteryblockViewer.draw(mb, gui);

        verify(gui).drawMysteryBlock(mb, new Position(5, 10));
    }
}
