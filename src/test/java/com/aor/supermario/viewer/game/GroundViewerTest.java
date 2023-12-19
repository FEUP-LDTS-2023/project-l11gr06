package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Ground;
import com.aor.supermario.viewer.game.GroundViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class GroundViewerTest {

    @Test
    void drawGround() {
        GUI gui = Mockito.mock(GUI.class);
        Ground ground = new Ground(new Position(5, 10));
        GroundViewer groundViewer = new GroundViewer();
        groundViewer.draw(ground, gui);

        verify(gui).drawGround(new Position(5, 10));
    }
}