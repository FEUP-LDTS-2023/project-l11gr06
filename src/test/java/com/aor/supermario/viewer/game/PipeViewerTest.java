package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.Position;
import com.aor.supermario.model.elements.Pipe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class PipeViewerTest {
    @Test
    void drawPipe() {
        char character='C';
        GUI gui = Mockito.mock(GUI.class);
        Pipe pipe = new Pipe(new Position(5, 10),character);
        PipeViewer pipeViewer = new PipeViewer();
        pipeViewer.draw(pipe, gui);

        verify(gui).drawPipe(new Position(5, 10));
    }
}
