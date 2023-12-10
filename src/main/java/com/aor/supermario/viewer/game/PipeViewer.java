package com.aor.supermario.viewer.game;

import com.aor.supermario.model.elements.Pipe;
import com.aor.supermario.gui.GUI;

public class PipeViewer implements ElementViewer<Pipe> {
    @Override
    public void draw(Pipe pipe, GUI gui) {
        gui.drawPipe(pipe.getPosition(), pipe.getCharacter());
    }
}
