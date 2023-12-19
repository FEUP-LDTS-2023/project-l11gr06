package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Stair;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class StairViewerTest {
    @Test
    void drawStair() {
        GUI gui = Mockito.mock(GUI.class);
        Stair stair = new Stair(new Position(5, 10));
        StairViewer stairViewer = new StairViewer();
        stairViewer.draw(stair, gui);

        verify(gui).drawStair(new Position(5, 10));
    }
}
