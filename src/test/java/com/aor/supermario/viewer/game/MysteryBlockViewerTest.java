package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Ground;
import com.aor.supermario.model.elements.MysteryBlock;
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
