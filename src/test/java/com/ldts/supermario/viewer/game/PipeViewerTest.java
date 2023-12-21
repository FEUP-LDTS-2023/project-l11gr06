package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.Pipe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class PipeViewerTest {
    @Test
    void drawPipe() {
        GUI gui = Mockito.mock(GUI.class);
        Pipe pipe = new Pipe(new Position(5, 10));
        PipeViewer pipeViewer = new PipeViewer();
        pipeViewer.draw(pipe, gui);

        verify(gui).drawPipe(new Position(5, 10));
    }
}
