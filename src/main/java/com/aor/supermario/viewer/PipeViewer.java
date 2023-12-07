package com.aor.supermario.viewer;

import com.aor.supermario.elements.Element;
import com.aor.supermario.elements.Pipe;
import com.aor.supermario.gui.GUI;

public class PipeViewer implements ElementViewer<Pipe> {
    @Override
    public void draw(Pipe pipe, GUI gui) {
        gui.drawPipe(Element.getPosition());
    }
}
