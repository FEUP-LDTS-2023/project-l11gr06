package com.ldts.supermario.viewer.game;

import com.ldts.supermario.model.elements.Pipe;
import com.ldts.supermario.gui.GUI;

public class PipeViewer implements ElementViewer<Pipe> {
    @Override
    public void draw(Pipe pipe, GUI gui) {
        gui.drawPipe(pipe.getPosition());
    }
}
